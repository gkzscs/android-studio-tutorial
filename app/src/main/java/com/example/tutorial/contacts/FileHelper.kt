package com.example.tutorial.contacts

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileWriter
import java.util.jar.Manifest

object FileHelper {
    private var listUsers = ArrayList<User?>()
    private var filePath: String = ""

    fun setFilePath(str: String) {
        filePath = str
        Log.i("FileHelper", "filePath: $filePath")
    }

    fun setLastUser(usr: User) {
        val fileName = "${filePath}/last_account.yaml"
        val file = File(fileName)
        if (!file.exists()) {
            file.createNewFile()
        }

        val line = convertUser2Str(usr)
        file.writeText(line)
    }

    fun getUsers() : ArrayList<User?> {
        return listUsers
    }

    fun addUser(usr: User) {
        val line = convertUser2Str(usr)
        var file = configFile() ?: return
        file.appendText("$line\n")
        Log.i("FileHelper", "add user: $line")
        readConfigFile()
    }

    /**
     * Check if there exists the user name
     */
    fun existsUser(name: String) : Boolean {
        Log.i("FileHelper", "Exists user")
        readConfigFile()
        Log.i("FileHelper", "users: $listUsers")
        for (usr in listUsers) {
            if (usr == null || usr.name != name) continue
            return true
        }

        return false
    }

    /**
     * Get last saved user
     */
    fun lastUser() : User? {
        val fileName = "${filePath}/last_account.yaml"
        val file = File(fileName)
        if (!file.exists()) return null

        val listLines = file.readLines()
        if (listLines.isEmpty()) return null

        return parseLine2User(listLines.first())
    }

    fun showMessage(ctx: Context, msg: String) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
    }

    /****************************************** Private Methods ****************************************/
    private fun configFile() : File? {
        val fileName = "${filePath}/config.yaml"
        val file = File(fileName)
        if (file.exists()) {
            Log.i("FileHelper", "$fileName exists")
            return file
        }

        val created = file.createNewFile()
        if (created) {
            Log.i("FileHelper", "$fileName created successfully")
        } else {
            Log.i("FileHelper", "$fileName failed to create")
            return null
        }

        return file
    }

    private fun readConfigFile() {
        Log.i("FileHelper", "before config file")
        val file = configFile() ?: return

        Log.i("FileHelper", "before read lines")
        val listLines = file.readLines()

        Log.i("FileHelper", "before parse data:$listLines")
        listUsers = parseData(listLines)
        Log.i("FileHelper.read", listUsers.toArray().toString())
    }

    private fun parseData(listLines: List<String>) : ArrayList<User?> {
        var listUsers = ArrayList<User?>()
        for (line in listLines) {
            val usr = parseLine2User(line)
            listUsers.add(usr)
        }

        return listUsers
    }

    private fun parseLine2User(line: String) : User? {
        var str = line.replace("\\s".toRegex(), "")
        if (str.first() != '{' || str.last() != '}') return null

        var usr = User()
        str = str.removePrefix("{")
        str = str.removeSuffix("}")
        val listKeyValues = str.split(',')
        for (strKeyValue in listKeyValues) {
            parseUserProperty(usr, strKeyValue)
        }

        return usr
    }

    private fun parseUserProperty(usr: User, strKeyValue: String) {
        val keyValue = strKeyValue.split(':')
        if (keyValue.size != 2) return

        val key = keyValue.first()
        val value = keyValue.last()

        when (key) {
            "password" -> usr.password = value
            "name" -> usr.name = value
            else -> println("Key not matched")
        }
    }

    private fun convertUser2Str(usr: User) : String {
        return "{name:${usr.name}, password: ${usr.password}}"
    }
}