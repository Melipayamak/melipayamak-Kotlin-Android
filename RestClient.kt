class RestClient(private val UserName: String, private val Password: String) {

    private val endpoint = "https://rest.payamak-panel.com/api/SendSMS/"
    private val sendOp = "SendSMS"
    private val sendByBaseNumberOp = "BaseServiceNumber";

    private val getDeliveryOp = "GetDeliveries2"
    private val getMessagesOp = "GetMessages"
    private val getCreditOp = "GetCredit"
    private val getBasePriceOp = "GetBasePrice"
    private val getUserNumbersOp = "GetUserNumbers"


    @Throws(IOException::class)
    fun Send(to: String, from: String, message: String, isflash: Boolean): String {

        val values = Hashtable<String, String>()
        values.put("username", UserName)
        values.put("password", Password)
        values.put("to", to)
        values.put("from", from)
        values.put("text", message)
        values.put("isFlash", isflash.toString())

        val url = URL(endpoint + sendOp)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"

        val result = StringBuilder()
        var line: String

        try {
            conn.doOutput = true
            conn.setChunkedStreamingMode(0)

            //consider encoding
            val writer = OutputStreamWriter(conn.outputStream)
            writer.write(getPostParamString(values))
            writer.flush()
            writer.close()

            //you can deserialize response as it is json
            val r = BufferedReader(InputStreamReader(conn.inputStream))
            line = r.readLine()
            while ( line != null) {
                result.append(line).append('\n')
            }

        } finally {
            conn.disconnect()
        }

        return result.toString()
    }

    @Throws(IOException::class)
    fun SendByBaseNumber(text: String, to: String, bodyId: Long): String {

        val values = Hashtable<String, String>()
        values.put("username", UserName)
        values.put("password", Password)
        values.put("text", text)
        values.put("to", to)
        values.put("bodyId", bodyId.toString())

        val url = URL(endpoint + sendByBaseNumberOp)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"

        val result = StringBuilder()
        var line: String

        try {
            conn.doOutput = true
            conn.setChunkedStreamingMode(0)

            //consider encoding
            val writer = OutputStreamWriter(conn.outputStream)
            writer.write(getPostParamString(values))
            writer.flush()
            writer.close()

            //you can deserialize response as it is json
            val r = BufferedReader(InputStreamReader(conn.inputStream))
            line = r.readLine()
            while ( line != null) {
                result.append(line).append('\n')
            }

        } finally {
            conn.disconnect()
        }

        return result.toString()
    }

    @Throws(IOException::class)
    fun GetDelivery(recid: Long): String {

        val values = Hashtable<String, String>()
        values.put("username", UserName)
        values.put("password", Password)
        values.put("recID", recid.toString())

        val url = URL(endpoint + getDeliveryOp)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"

        val result = StringBuilder()
        var line: String

        try {
            conn.doOutput = true
            conn.setChunkedStreamingMode(0)

            //consider encoding
            val writer = OutputStreamWriter(conn.outputStream)
            writer.write(getPostParamString(values))
            writer.flush()
            writer.close()

            //you can deserialize response as it is json
            val r = BufferedReader(InputStreamReader(conn.inputStream))
            line = r.readLine()
            while ( line != null) {
                result.append(line).append('\n')
            }

        } finally {
            conn.disconnect()
        }

        return result.toString()
    }


    @Throws(IOException::class)
    fun GetMessages(location: Int, from: String, index: String, count: Int): String {

        val values = Hashtable<String, String>()
        values.put("username", UserName)
        values.put("password", Password)
        values.put("Location", location.toString())
        values.put("From", from)
        values.put("Index", index)
        values.put("Count", count.toString())

        val url = URL(endpoint + getMessagesOp)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"

        val result = StringBuilder()
        var line: String

        try {
            conn.doOutput = true
            conn.setChunkedStreamingMode(0)

            //consider encoding
            val writer = OutputStreamWriter(conn.outputStream)
            writer.write(getPostParamString(values))
            writer.flush()
            writer.close()

            //you can deserialize response as it is json
            val r = BufferedReader(InputStreamReader(conn.inputStream))
            line = r.readLine()
            while ( line != null) {
                result.append(line).append('\n')
            }

        } finally {
            conn.disconnect()
        }

        return result.toString()
    }

    @Throws(IOException::class)
    fun GetCredit(): String {

        val values = Hashtable<String, String>()
        values.put("username", UserName)
        values.put("password", Password)

        val url = URL(endpoint + getCreditOp)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"

        val result = StringBuilder()
        var line: String

        try {
            conn.doOutput = true
            conn.setChunkedStreamingMode(0)

            //consider encoding
            val writer = OutputStreamWriter(conn.outputStream)
            writer.write(getPostParamString(values))
            writer.flush()
            writer.close()

            //you can deserialize response as it is json
            val r = BufferedReader(InputStreamReader(conn.inputStream))
            line = r.readLine()
            while ( line != null) {
                result.append(line).append('\n')
            }

        } finally {
            conn.disconnect()
        }

        return result.toString()
    }

    @Throws(IOException::class)
    fun GetBasePrice(): String {

        val values = Hashtable<String, String>()
        values.put("username", UserName)
        values.put("password", Password)

        val url = URL(endpoint + getBasePriceOp)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"

        val result = StringBuilder()
        var line: String

        try {
            conn.doOutput = true
            conn.setChunkedStreamingMode(0)

            //consider encoding
            val writer = OutputStreamWriter(conn.outputStream)
            writer.write(getPostParamString(values))
            writer.flush()
            writer.close()

            //you can deserialize response as it is json
            val r = BufferedReader(InputStreamReader(conn.inputStream))
            line = r.readLine()
            while ( line != null) {
                result.append(line).append('\n')
            }

        } finally {
            conn.disconnect()
        }

        return result.toString()
    }

    @Throws(IOException::class)
    fun GetUserNumbers(): String {

        val values = Hashtable<String, String>()
        values.put("username", UserName)
        values.put("password", Password)

        val url = URL(endpoint + getUserNumbersOp)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"

        val result = StringBuilder()
        var line: String

        try {
            conn.doOutput = true
            conn.setChunkedStreamingMode(0)

            //consider encoding
            val writer = OutputStreamWriter(conn.outputStream)
            writer.write(getPostParamString(values))
            writer.flush()
            writer.close()

            //you can deserialize response as it is json
            val r = BufferedReader(InputStreamReader(conn.inputStream))
            line = r.readLine()
            while ( line != null) {
                result.append(line).append('\n')
            }

        } finally {
            conn.disconnect()
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
}
