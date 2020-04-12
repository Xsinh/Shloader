# Shloader
[ ![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.xsinh/shloader/badge.svg) ](https://search.maven.org/artifact/io.github.xsinh/shloader)

Simple lib for loading glsl scripts from row directory

# Example

- No longer need to write scripts in code as `String()` make glsl-scripts in row dirctory:

<img width="1059" alt="Снимок экрана 2020-04-12 в 18 39 16" src="https://user-images.githubusercontent.com/17497471/79073083-2f3f6a80-7ced-11ea-8fc8-19a222381091.png">

- Now you can simple load scripts by means of static `loadShader` method

```kotlin
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
```
# Integration

version of 1.0.1 not work, use 1.0.0

```groovy
repositories {
    // ...
    mavenCentral()
}
dependencies {
    // ...
    implementation 'io.github.xsinh:shloader:1.0.0'
}
```
