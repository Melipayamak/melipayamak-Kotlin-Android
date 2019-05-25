class SoapClient//constructor
(private val Username: String, private val Password: String) {


    protected fun getXMLResult(url: String, soapAction: String, request: SoapObject): SoapObject? {
        try {
            return getServiceResult(url, soapAction, request)
        } catch (e: SoapFault) {
            e.printStackTrace()
            return null
        } catch (e: HttpResponseException) {
            e.printStackTrace()
            return null
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
            return null
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }

    }

    //send webservice
    fun SendSimpleSMS2(to: String, from: String, text: String, isFlash: Boolean): Any {

        val METHOD_NAME = "SendSimpleSMS2"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", to)
        request.addProperty("text", text)
        request.addProperty("isflash", isFlash.toString())

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SEND_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetCredit(): Any {

        val METHOD_NAME = "GetCredit"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SEND_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetDeliveries(recIds: LongArray): Any {

        val METHOD_NAME = "GetDeliveries"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("recIds", recIds)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SEND_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetSmsPrice(irancellCount: Int, mtnCount: Int, from: String, text: String): Any {

        val METHOD_NAME = "GetSmsPrice"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("irancellCount", irancellCount)
        request.addProperty("mtnCount", mtnCount)
        request.addProperty("from", from)
        request.addProperty("text", text)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SEND_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun SendSimpleSMS(to: Array<String>, from: String, text: String, isFlash: Boolean): Any {

        val METHOD_NAME = "SendSimpleSMS"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", to)
        request.addProperty("text", text)
        request.addProperty("isflash", isFlash.toString())

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SEND_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun SendSms(to: String, from: String, text: String, isFlash: Boolean, udh: String, recId: LongArray, status: Base64): Any {

        val METHOD_NAME = "SendSms"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", to)
        request.addProperty("text", text)
        request.addProperty("isflash", isFlash.toString())
        request.addProperty("udh", udh)
        request.addProperty("recId", recId)
        request.addProperty("status", status)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SEND_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun SendByBaseNumber(text: Array<String>, to: String, bodyId: Int): Any {

        val METHOD_NAME = "SendByBaseNumber"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("text", text)
        request.addProperty("to", to)
        request.addProperty("bodyId", bodyId.toString())

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SEND_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun SendByBaseNumber2(text: String, to: String, bodyId: Int): Any {

        val METHOD_NAME = "SendByBaseNumber2"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("text", text)
        request.addProperty("to", to)
        request.addProperty("bodyId", bodyId.toString())

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SEND_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun getMessages(location: Int, from: String, index: Int, count: Int): Any {

        val METHOD_NAME = "getMessages"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("location", location)
        request.addProperty("index", index)
        request.addProperty("count", count)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SEND_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }


    //receive webservice
    fun GetMessagesReceptions(msgId: Int, fromRows: Int): Any {

        val METHOD_NAME = "GetMessagesReceptions"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("msgId", msgId)
        request.addProperty("fromRows", fromRows)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(RECEIVE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun RemoveMessages2(location: Int, msgIds: String): Any {

        val METHOD_NAME = "RemoveMessages2"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("location", location)
        request.addProperty("msgIds", msgIds)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(RECEIVE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetMessagesByDate(location: Int, from: String, index: Int, count: Int, dateFrom: Date, dateTo: Date): Any {

        val METHOD_NAME = "GetMessagesByDate"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("location", location)
        request.addProperty("from", from)
        request.addProperty("index", index)
        request.addProperty("count", count)
        request.addProperty("dateFrom", dateFrom)
        request.addProperty("dateTo", dateTo)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(RECEIVE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetUsersMessagesByDate(location: Int, from: String, index: Int, count: Int, dateFrom: Date, dateTo: Date): Any {

        val METHOD_NAME = "GetUsersMessagesByDate"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("location", location)
        request.addProperty("from", from)
        request.addProperty("index", index)
        request.addProperty("count", count)
        request.addProperty("dateFrom", dateFrom)
        request.addProperty("dateTo", dateTo)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(RECEIVE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }


    //users webservice
    fun GetUserNumbers(): Any {

        val METHOD_NAME = "GetUserNumbers"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetUserTransactions(targetUsername: String, creditType: String, keyword: String, dateFrom: Date, dateTo: Date): Any {

        val METHOD_NAME = "GetUserTransactions"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)
        request.addProperty("creditType", creditType)
        request.addProperty("keyword", keyword)
        request.addProperty("dateFrom", dateFrom)
        request.addProperty("dateTo", dateTo)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetUsers(): Any {

        val METHOD_NAME = "GetUsers"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun HasFilter(text: String): Any {

        val METHOD_NAME = "HasFilter"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("text", text)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun RemoveUser(targetUsername: String): Any {

        val METHOD_NAME = "RemoveUser"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetProvinces(): Any {

        val METHOD_NAME = "GetProvinces"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetCities(provinceId: Int): Any {

        val METHOD_NAME = "GetCities"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("provinceId", provinceId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetExpireDate(): Any {

        val METHOD_NAME = "GetExpireDate"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun AddPayment(name: String, family: String, bankName: String, code: String, amount: Double, cardNumber: String): Any {

        val METHOD_NAME = "AddPayment"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("name", name)
        request.addProperty("family", family)
        request.addProperty("bankName", bankName)
        request.addProperty("code", code)
        request.addProperty("amount", amount)
        request.addProperty("cardNumber", cardNumber)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun AuthenticateUser(): Any {

        val METHOD_NAME = "AuthenticateUser"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun ChangeUserCredit(amount: Double, description: String, targetUsername: String, GetTax: Boolean): Any {

        val METHOD_NAME = "ChangeUserCredit"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)
        request.addProperty("description", description)
        request.addProperty("amount", amount)
        request.addProperty("GetTax", GetTax.toString())

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun AuthenticateUser(mobileNumber: String, emailAddress: String, targetUsername: String): Any {

        val METHOD_NAME = "AuthenticateUser"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("mobileNumber", mobileNumber)
        request.addProperty("emailAddress", emailAddress)
        request.addProperty("targetUsername", targetUsername)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetUserBasePrice(targetUsername: String): Any {

        val METHOD_NAME = "GetUserBasePrice"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetUserCredit(targetUsername: String): Any {

        val METHOD_NAME = "GetUserCredit"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetUserDetails(targetUsername: String): Any {

        val METHOD_NAME = "GetUserDetails"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetUserDetails(targetUsername: String, creditType: String, dateFrom: Date, dateTo: Date, keyword: String): Any {

        val METHOD_NAME = "GetUserDetails"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)
        request.addProperty("creditType", creditType)
        request.addProperty("dateFrom", dateFrom)
        request.addProperty("dateTo", dateTo)
        request.addProperty("keyword", keyword)


        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(USERS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }


    //contacts webservice
    fun AddGroup(groupName: String, Descriptions: String, showToChilds: Boolean): Any {

        val METHOD_NAME = "AddGroup"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("groupName", groupName)
        request.addProperty("Descriptions", Descriptions)
        request.addProperty("showToChilds", showToChilds.toString())

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(CONTACTS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun CheckMobileExistInContact(mobileNumber: String): Any {

        val METHOD_NAME = "CheckMobileExistInContact"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("mobileNumber", mobileNumber)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(CONTACTS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetContacts(groupId: Int, keyword: String, from: Int, count: Int): Any {

        val METHOD_NAME = "GetContacts"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("groupId", groupId)
        request.addProperty("keyword", keyword)
        request.addProperty("count", count)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(CONTACTS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetGroups(): Any {

        val METHOD_NAME = "GetGroups"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(CONTACTS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun RemoveContact(mobilenumber: String): Any {

        val METHOD_NAME = "RemoveContact"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("mobilenumber", mobilenumber)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(CONTACTS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetContactEvents(contactId: Int): Any {

        val METHOD_NAME = "GetContactEvents"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("contactId", contactId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(CONTACTS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }


    //actions webservice
    fun GetBranchs(owner: Int): Any {

        val METHOD_NAME = "GetBranchs"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("owner", owner)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun AddBranch(owner: Int, branchName: String): Any {

        val METHOD_NAME = "AddBranch"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("owner", owner)
        request.addProperty("branchName", branchName)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun AddNumber(branchId: Int, mobileNumbers: Array<String>): Any {

        val METHOD_NAME = "AddNumber"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("branchId", branchId)
        request.addProperty("mobileNumbers", mobileNumbers)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun RemoveBranch(branchId: Int): Any {

        val METHOD_NAME = "RemoveBranch"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("branchId", branchId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun AddBulk(from: String, branch: Int, bulkType: Byte?, title: String, message: String,
                rangeFrom: String, rangeTo: String, DateToSend: Date, requestCount: Int, rowFrom: Int): Any {

        val METHOD_NAME = "AddBulk"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("branch", branch)
        request.addProperty("bulkType", bulkType)
        request.addProperty("title", title)
        request.addProperty("message", message)
        request.addProperty("rangeFrom", rangeFrom)
        request.addProperty("rangeTo", rangeTo)
        request.addProperty("DateToSend", DateToSend)
        request.addProperty("requestCount", requestCount)
        request.addProperty("rowFrom", rowFrom)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetBulkCount(branch: Int, rangeFrom: String, rangeTo: String): Any {

        val METHOD_NAME = "GetBulkCount"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("branch", branch)
        request.addProperty("rangeFrom", rangeFrom)
        request.addProperty("rangeTo", rangeTo)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetBulkReceptions(bulkId: Int, fromRows: Int): Any {

        val METHOD_NAME = "GetBulkReceptions"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("bulkId", bulkId)
        request.addProperty("fromRows", fromRows)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetBulkStatus(bulkId: Int, sent: Int, failed: Int, status: Byte): Any {

        val METHOD_NAME = "GetBulkStatus"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("bulkId", bulkId)
        request.addProperty("sent", sent)
        request.addProperty("failed", failed)
        request.addProperty("status", status)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetTodaySent(): Any {

        val METHOD_NAME = "GetTodaySent"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetTotalSent(): Any {

        val METHOD_NAME = "GetTotalSent"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun RemoveBulk(bulkId: Int): Any {

        val METHOD_NAME = "RemoveBulk"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("bulkId", bulkId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun SendMultipleSMS(to: Array<String>, from: String, text: Array<String>, isflash: Boolean, udh: String,
                        recId: LongArray): Any {

        val METHOD_NAME = "SendMultipleSMS"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("to", to)
        request.addProperty("from", from)
        request.addProperty("text", text)
        request.addProperty("isflash", isflash.toString())
        request.addProperty("udh", udh)
        request.addProperty("recId", recId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun UpdateBulkDelivery(bulkId: Int): Any {

        val METHOD_NAME = "UpdateBulkDelivery"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("bulkId", bulkId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(ACTIONS_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }


    //schedule webservice
    fun AddSchedule(to: String, from: String, text: String, isFlash: Boolean, scheduleDateTime: Date,
                    period: String): Any {

        val METHOD_NAME = "AddSchedule"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", to)
        request.addProperty("text", text)
        request.addProperty("isflash", isFlash.toString())
        request.addProperty("scheduleDateTime", scheduleDateTime)
        request.addProperty("period", period)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SCHEDULE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun AddMultipleSchedule(to: Array<String>, from: String, text: Array<String>, isFlash: Boolean, scheduleDateTime: Array<Date>,
                            period: String): Any {

        val METHOD_NAME = "AddMultipleSchedule"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", to)
        request.addProperty("text", text)
        request.addProperty("isflash", isFlash.toString())
        request.addProperty("scheduleDateTime", scheduleDateTime)
        request.addProperty("period", period)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SCHEDULE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun AddNewUsance(to: String, from: String, text: String, isFlash: Boolean, countrepeat: Int,
                     scheduleEndDateTime: Date, periodType: String): Any {

        val METHOD_NAME = "AddNewUsance"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", to)
        request.addProperty("text", text)
        request.addProperty("isflash", isFlash.toString())
        request.addProperty("countrepeat", countrepeat)
        request.addProperty("scheduleEndDateTime", scheduleEndDateTime)
        request.addProperty("periodType", periodType)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SCHEDULE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun GetScheduleStatus(scheduleId: Int): Any {

        val METHOD_NAME = "GetScheduleStatus"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("scheduleId", scheduleId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SCHEDULE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun RemoveSchedule(scheduleId: Int): Any {

        val METHOD_NAME = "RemoveSchedule"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("scheduleId", scheduleId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(SCHEDULE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }


    //voice webservice
    fun GetSendSMSWithSpeechTextStatus(recId: Long): Any {

        val METHOD_NAME = "GetSendSMSWithSpeechTextStatus"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("recId", recId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(VOICE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun SendBulkSpeechText(title: String, body: String, receivers: String, DateToSend: String, repeatCount: Int): Any {

        val METHOD_NAME = "SendBulkSpeechText"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("title", title)
        request.addProperty("body", body)
        request.addProperty("receivers", receivers)
        request.addProperty("DateToSend", DateToSend)
        request.addProperty("repeatCount", repeatCount)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(VOICE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun SendBulkVoiceSMS(title: String, voiceFileId: Int, receivers: String, DateToSend: String, repeatCount: Int): Any {

        val METHOD_NAME = "SendBulkVoiceSMS"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("title", title)
        request.addProperty("voiceFileId", voiceFileId)
        request.addProperty("receivers", receivers)
        request.addProperty("DateToSend", DateToSend)
        request.addProperty("repeatCount", repeatCount)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(VOICE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun UploadVoiceFile(title: String, base64StringFile: String): Any {

        val METHOD_NAME = "UploadVoiceFile"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("title", title)
        request.addProperty("base64StringFile", base64StringFile)
        
        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(VOICE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun SendSMSWithSpeechText(smsBody: String, speechBody: String, from: String, to: String): Any {

        val METHOD_NAME = "SendSMSWithSpeechText"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", to)
        request.addProperty("smsBody", smsBody)
        request.addProperty("speechBody", speechBody)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(VOICE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }

    fun SendSMSWithSpeechTextBySchduleDate(smsBody: String, speechBody: String, from: String, to: String,
                                           scheduleDate: Date): Any {

        val METHOD_NAME = "SendSMSWithSpeechTextBySchduleDate"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", to)
        request.addProperty("smsBody", smsBody)
        request.addProperty("speechBody", speechBody)
        request.addProperty("scheduleDate", scheduleDate)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        val response = getXMLResult(VOICE_URL, SOAP_ACTION, request)

        return response!!.getProperty(0)
    }








    companion object {

        //    private static String SOAP_ACTION = "http://tempuri.org/SendSimpleSMS2";
        private val NAMESPACE = "http://tempuri.org/"
        //    private static String METHOD_NAME = "SendSimpleSMS2";
        private val SEND_URL = "http://api.payamak-panel.com/post/send.asmx"
        private val RECEIVE_URL = "http://api.payamak-panel.com/post/receive.asmx"
        private val USERS_URL = "http://api.payamak-panel.com/post/Users.asmx"
        private val CONTACTS_URL = "http://api.payamak-panel.com/post/contacts.asmx"
        private val ACTIONS_URL = "http://api.payamak-panel.com/post/actions.asmx"
        private val SCHEDULE_URL = "http://api.payamak-panel.com/post/Schedule.asmx"
        private val VOICE_URL = "http://api.payamak-panel.com/post/Voice.asmx"

        private val TAG = "melipayamak"


        @Throws(XmlPullParserException::class, IOException::class)
        private fun getServiceResult(strURL: String, strSoapAction: String, request: SoapObject): SoapObject {


            // Create envelope
            //Declare the version of the SOAP request
            val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
            envelope.dotNet = true

            // Set output SOAP object
            envelope.setOutputSoapObject(request)

            // Create HTTP call object
            val androidHttpTransport = HttpTransportSE(strURL)
            androidHttpTransport.debug = true

            val response: SoapObject

            // StringBuffer result = null;

            System.setProperty("http.keepAlive", "false")

            try {
                // Invoke web service
                androidHttpTransport.call(strSoapAction, envelope)

                // Get the response
                response = envelope.bodyIn as SoapObject
                //            StringBuffer result;
                //            result = new StringBuffer(response.toString());
                Log.d(TAG, response.toString())


            } catch (e: SoapFault) {
                Log.e(TAG, "SoapFaultException")
                throw e
            } catch (e: HttpResponseException) {
                Log.e(TAG, "HttpResponseException")
                throw e
            } catch (e: XmlPullParserException) {
                Log.e(TAG, "XmlPullParserException")
                throw e
            } catch (e: IOException) {
                Log.e(TAG, "IOException")
                throw e
            }

            return response
        }
    }

}
