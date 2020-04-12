package com.implozia.shloader

import android.content.Context
import android.content.res.Resources
import android.opengl.GLES20
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object Shloader {

    fun loadShader(shaderType: Int, source: Int, context: Context): Int {
        val shader = GLES20.glCreateShader(shaderType)
        GLES20.glShaderSource(shader, readTextFromRaw(context, source))
        GLES20.glCompileShader(shader)
        return shader
    }

    private fun readTextFromRaw(context: Context, resourceId: Int): String? {
        var stringBuilder = StringBuilder()
        try {
            var bufferedReader: BufferedReader? = null
            try {
                val inputStream =
                    context.resources.openRawResource(resourceId)
                bufferedReader = BufferedReader(InputStreamReader(inputStream))
                var line: String?
                while (bufferedReader.readLine().also { line = it } != null) {
                    stringBuilder.append(line)
                    stringBuilder.append("\r\n")
                }
            } finally {
                bufferedReader?.close()
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        } catch (notFoundException: Resources.NotFoundException) {
            notFoundException.printStackTrace()
        }
        return stringBuilder.toString()
    }
}