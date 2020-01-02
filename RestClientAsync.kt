package ir.mp.java.mpjava

import android.os.AsyncTask

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.ProtocolException
import java.net.URL
import java.util.Enumeration
import java.util.HashSet
import java.util.Hashtable

class RestClientAsync(private val UserName: String, private val Password: String) : AsyncTask<MPRestTaskParams, Int, String>() {

    private val endpoint = "https://rest.payamak-panel.com/api/SendSMS/"

    private val sendOp = "SendSMS"
    private val sendByBaseNumber = "BaseServiceNumber"
    private val getDeliveryOp = "GetDeliveries2"
    private val getMessagesOp = "GetMessages"
    private val getCreditOp = "GetCredit"
    private val getBasePriceOp = "GetBasePrice"
    private val getUserNumbersOp = "GetUserNumbers"

    override fun doInBackground(vararg params: MPRestTaskParams): String {
        var conn: HttpURLConnection? = null
        try {
            conn = params[0].url.openConnection() as HttpURLConnection
        } catch (e: IOException) {
            e.printStackTrace()
        }

        try {
            conn!!.requestMethod = "POST"
        } catch (e: ProtocolException) {
            e.printStackTrace()
        }

        val result = StringBuilder()
        var line: String

        try {
            conn!!.doOutput = true
            conn.setChunkedStreamingMode(0)

            //consider encoding
            val writer = OutputStreamWriter(conn.outputStream)
            writer.write(getPostParamString(params[0].values))
            writer.flush()
            writer.close()

            //you can deserialize response as it is json
            val r = BufferedReader(InputStreamReader(conn.inputStream))
            line = r.readLine()
            while (line != null) {
                result.append(line).append('\n')
            }

        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            conn!!.disconnect()
        }

        return result.toString()
    }

    private fun getPostParamString(params: Hashtable<String, String>): String {
        if (params.size == 0)
            return ""

        val buf = StringBuffer()
        val keys = params.keys()
        while (keys.hasMoreElements()) {
            buf.append(if (buf.length == 0) "" else "&")
            val key = keys.nextElement()
            buf.append(key).append("=").append(params[key])
        }
        return buf.toString()
    }


    @Throws(IOException::class)
    fun Send(to: String, from: String, message: String, isflash: Boolean) {

        val values = Hashtable<String, String>()
        values["username"] = UserName
        values["password"] = Password
        values["to"] = to
        values["from"] = from
        values["text"] = message
        values["isFlash"] = isflash.toString()

        val url = URL(endpoint + sendOp)
        execute(*arrayOf(MPRestTaskParams(url, values)))
    }

    @Throws(IOException::class)
    fun SendByBaseNumber(text: String, to: String, bodyId: Long) {

        val values = Hashtable<String, String>()
        values["username"] = UserName
        values["password"] = Password
        values["to"] = to
        values["text"] = text
        values["bodyId"] = bodyId.toString()

        val url = URL(endpoint + sendByBaseNumber)
        execute(*arrayOf(MPRestTaskParams(url, values)))
    }

    @Throws(IOException::class)
    fun GetDelivery(recid: Long) {

        val values = Hashtable<String, String>()
        values["username"] = UserName
        values["password"] = Password
        values["recID"] = recid.toString()

        val url = URL(endpoint + getDeliveryOp)
        execute(*arrayOf(MPRestTaskParams(url, values)))
    }


    @Throws(IOException::class)
    fun GetMessages(location: Int, from: String, index: String, count: Int) {

        val values = Hashtable<String, String>()
        values["username"] = UserName
        values["password"] = Password
        values["Location"] = location.toString()
        values["From"] = from
        values["Index"] = index
        values["Count"] = count.toString()

        val url = URL(endpoint + getMessagesOp)
        execute(*arrayOf(MPRestTaskParams(url, values)))
    }

    @Throws(IOException::class)
    fun GetCredit() {

        val values = Hashtable<String, String>()
        values["username"] = UserName
        values["password"] = Password

        val url = URL(endpoint + getCreditOp)
        execute(*arrayOf(MPRestTaskParams(url, values)))
    }

    @Throws(IOException::class)
    fun GetBasePrice() {

        val values = Hashtable<String, String>()
        values["username"] = UserName
        values["password"] = Password

        val url = URL(endpoint + getBasePriceOp)
        execute(*arrayOf(MPRestTaskParams(url, values)))
    }

    @Throws(IOException::class)
    fun GetUserNumbers() {

        val values = Hashtable<String, String>()
        values["username"] = UserName
        values["password"] = Password

        val url = URL(endpoint + getUserNumbersOp)
        execute(*arrayOf(MPRestTaskParams(url, values)))
    }


}


class MPRestTaskParams(var url: URL, var values: Hashtable<String, String>)