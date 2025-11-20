// aided by chat starting the generic function

sealed class SmartDevice (  // inheritance class where this is the parent the rest are children
    var name: String,
    var isEnabled: Boolean = false
) {
    class Light(name: String, isEnabled: Boolean = false, var brightnessLevel: Int) : SmartDevice(name, isEnabled) {
        fun turnOn() { isEnabled = true }
        fun turnOff() { isEnabled = false }
    }
    class Thermostat(name: String, isEnabled: Boolean = false, var currentTemperature: Float, var targetTemperature: Float) : SmartDevice(name, isEnabled) {
        fun turnOn() { isEnabled = true }
        fun turnOff() { isEnabled = false }
    }
    class SecurityCamera(name: String, isEnabled: Boolean = false, var isRecording: Boolean) : SmartDevice(name, isEnabled) {
        fun turnOn() { isEnabled = true }
        fun turnOff() { isEnabled = false }
    }
}

class SmartHome {
    private val devices = mutableListOf<SmartDevice>()  // cannot instantiate parent but you can for children

    fun addDevice(device: SmartDevice) {
        devices.add(device)
    }

    fun turnAllOn() {
        devices.forEach{
            when (it) {
                is SmartDevice.Light -> it.turnOn()
                is SmartDevice.Thermostat -> it.turnOn()
                is SmartDevice.SecurityCamera -> it.turnOn()
            }
        }
    }

    fun turnAllOff() {
        devices.forEach{
            when (it) {
                is SmartDevice.Light -> it.turnOff()
                is SmartDevice.Thermostat -> it.turnOff()
                is SmartDevice.SecurityCamera -> it.turnOff()
            }
        }
    }

    // returns all devices in the devices list that match a specific class/type
    fun <T: SmartDevice> findDeviceByType(type: Class<T>): List<T> {  // creates a generic function
        return devices.filter { type.isInstance(it) }.map { type.cast(it)!! }  // check if the item is an instance of the class then cast it with map
    }

    // returns all devices that are currently turned on (isEnabled == true)
    fun getDevicesOn(): List<SmartDevice> {
        return devices.filter { it.isEnabled }  // only get whatever is enabled
    }

}

fun main() {
    val smartHome = SmartHome()

    val light1 = SmartDevice.Light("Living Room Light", brightnessLevel = 50)
    val light2 = SmartDevice.Light("Kitchen Light", brightnessLevel = 70)
    val thermostat = SmartDevice.Thermostat("Main Thermostat", currentTemperature = 24f, targetTemperature = 26f)
    val camera = SmartDevice.SecurityCamera("Front Door Camera", isRecording = false)

    smartHome.addDevice(light1)
    smartHome.addDevice(light2)
    smartHome.addDevice(thermostat)
    smartHome.addDevice(camera)

    smartHome.turnAllOn()

    println("Devices currently ON:")
    smartHome.getDevicesOn().forEach {
        println("- ${it.name}")
    }

    val lights = smartHome.findDeviceByType(SmartDevice.Light::class.java)  // converts to a java object as required by findDeviceByType
    println("\nLights in the home:")
    lights.forEach {
        println("- ${it.name}")
    }

    smartHome.turnAllOff()

    println("\nAfter turning everything OFF:")
    smartHome.getDevicesOn().forEach {
        println("- ${it.name}")
    }
}
