package com.implozia.shloaderexample

import android.content.Context
import android.opengl.GLES20
import android.opengl.GLES20.glUseProgram
import android.opengl.GLSurfaceView.Renderer
import com.implozia.shloader.Shloader.loadShader
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class RendererOpenGL constructor(private val context: Context) : Renderer {
    private var programId = 0

    override fun onDrawFrame(gl: GL10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT or GLES20.GL_DEPTH_BUFFER_BIT)
        glUseProgram(programId)
        GLES20.glDrawArrays(GLES20.GL_POINTS, 0, 1)
    }

    override fun onSurfaceCreated(gl: GL10, config: EGLConfig) =
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1f)

    override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {
        GLES20.glViewport(0, 0, width, height)
        attachShaders()
    }

    private fun attachShaders() {
        val pointVertexShader: Int =
            loadShader(GLES20.GL_VERTEX_SHADER, R.raw.vertex_shader, context)

        val pointFragmentShader: Int =
            loadShader(GLES20.GL_FRAGMENT_SHADER, R.raw.fragment_shader, context)

        programId = GLES20.glCreateProgram()

        GLES20.glAttachShader(programId, pointVertexShader)
        GLES20.glAttachShader(programId, pointFragmentShader)
        GLES20.glLinkProgram(programId)
    }
}