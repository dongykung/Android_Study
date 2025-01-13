package com.dkproject.compose_codelab.Chapter2.Grammer

open class SmartDevice(val name: String, val category: String){
    var deviceStatus = "online"

    // get() 함수에서 속성 값을 읽거나 set() 함수에서 값을 업데이트하려면 속성의 지원 필드를 사용해야 합니다.
    // 이 필드는 Kotlin 컴파일러에서 자동으로 생성되며 field 식별자로 참조됩니다.

    // 예를 들어 set() 함수에서 속성 값을 업데이트하려는 경우 위처럼 set() 함수의 매개변수(value 매개변수라고함)를 사용하고 이를 field 변수에 할당합니다

    constructor(name: String, category: String, statusCode: Int) : this(name, category){
        deviceStatus = when(statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }
    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    var speakerVolumn = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    var channelNumber = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }
    fun increaseSpeakerVolume() {
        speakerVolumn++
        println("Speaker volume increased to $speakerVolumn.")
    }
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
}

fun main() {
    val smartDevice: SmartDevice = SmartDevice("Android TV", "Entertainment")
    println("Device name is : ${smartDevice.name}")
    smartDevice.turnOn()
    smartDevice.turnOff()
    val smartLightDevice = SmartLightDevice(deviceName = "에어컨", deviceCategory = "가전제품")

    //IS-A관계
    //Smart TV IS-A smart device
}