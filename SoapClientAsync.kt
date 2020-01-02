package ir.mp.java.mpjava

import android.os.AsyncTask
import android.os.StrictMode
import android.text.TextUtils
import android.util.Log
import android.util.LongSparseArray

import org.kobjects.base64.Base64
import org.ksoap2.SoapEnvelope
import org.ksoap2.SoapFault
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpResponseException
import org.ksoap2.transport.HttpTransportSE
import org.xmlpull.v1.XmlPullParserException

import java.io.IOException
import java.io.StringReader
import java.sql.Date
import java.util.Collections


class SoapClientAsync//constructor
(private val Username: String, private val Password: String) : AsyncTask<MPTaskParams, Int, SoapObject>() {

    override fun doInBackground(vararg params: MPTaskParams): SoapObject? {
        // Create envelope
        //Declare the version of the SOAP request
        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
        envelope.dotNet = true

        // Set output SOAP object
        envelope.setOutputSoapObject(params[0].request)

        // Create HTTP call object
        val androidHttpTransport = HttpTransportSE(params[0].url)
        androidHttpTransport.debug = true

        val response: SoapObject?

        System.setProperty("http.keepAlive", "false")

        // Invoke web service
        try {
            androidHttpTransport.call(params[0].soapAction, envelope)
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        }

        // Get the response
        response = envelope.bodyIn as SoapObject
        if (response != null)
            Log.d(TAG, response.toString())

        return response
    }


    protected fun getXMLResult(url: String, soapAction: String, request: SoapObject) {
        this.execute(*arrayOf(MPTaskParams(url, soapAction, request)))
    }

    //send webservice
    fun SendSimpleSMS2(to: String, from: String, text: String, isFlash: Boolean) {

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
        getXMLResult(SEND_URL, SOAP_ACTION, request)
    }

    fun SendByBaseNumber(text: Array<String>, to: String, bodyId: Long) {

        val METHOD_NAME = "SendByBaseNumber"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        val _text = "<string>" + TextUtils.join("</string><string>", text) + "</string>"
        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("text", _text)
        request.addProperty("to", to)
        request.addProperty("bodyId", bodyId.toString())

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(SEND_URL, SOAP_ACTION, request)
    }

    fun SendByBaseNumber2(text: String, to: String, bodyId: Long) {

        val METHOD_NAME = "SendByBaseNumber2"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("text", text)
        request.addProperty("to", to)
        request.addProperty("bodyId", bodyId.toString())

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(SEND_URL, SOAP_ACTION, request)
    }

    fun GetCredit() {

        val METHOD_NAME = "GetCredit"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(SEND_URL, SOAP_ACTION, request)
    }

    fun GetDeliveries(recIds: LongArray) {

        val METHOD_NAME = "GetDeliveries"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        val _recIds = "<long>" + TextUtils.join("</long><long>", setOf(recIds)) + "</long>"
        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("recIds", _recIds)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(SEND_URL, SOAP_ACTION, request)
    }

    fun GetSmsPrice(irancellCount: Int, mtnCount: Int, from: String, text: String) {

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
        getXMLResult(SEND_URL, SOAP_ACTION, request)
    }

    fun SendSimpleSMS(to: Array<String>, from: String, text: String, isFlash: Boolean) {

        val METHOD_NAME = "SendSimpleSMS"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        val _to = "<string>" + TextUtils.join("</string><string>", to) + "</string>"
        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", _to)
        request.addProperty("text", text)
        request.addProperty("isflash", isFlash.toString())

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(SEND_URL, SOAP_ACTION, request)
    }

    fun SendSms(to: String, from: String, text: String, isFlash: Boolean, udh: String, recIds: LongArray, status: Base64) {

        val METHOD_NAME = "SendSms"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        val _recIds = "<long>" + TextUtils.join("</long><long>", setOf(recIds)) + "</long>"
        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", to)
        request.addProperty("text", text)
        request.addProperty("isflash", isFlash.toString())
        request.addProperty("udh", udh)
        request.addProperty("recId", _recIds)
        request.addProperty("status", status)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(SEND_URL, SOAP_ACTION, request)
    }

    fun getMessages(location: Int, from: String, index: Int, count: Int) {

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
        getXMLResult(SEND_URL, SOAP_ACTION, request)
    }


    //receive webservice
    fun GetMessagesReceptions(msgId: Int, fromRows: Int) {

        val METHOD_NAME = "GetMessagesReceptions"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("msgId", msgId)
        request.addProperty("fromRows", fromRows)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(RECEIVE_URL, SOAP_ACTION, request)
    }

    fun RemoveMessages2(location: Int, msgIds: String) {

        val METHOD_NAME = "RemoveMessages2"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("location", location)
        request.addProperty("msgIds", msgIds)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(RECEIVE_URL, SOAP_ACTION, request)
    }

    fun GetMessagesByDate(location: Int, from: String, index: Int, count: Int, dateFrom: Date, dateTo: Date) {

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
        getXMLResult(RECEIVE_URL, SOAP_ACTION, request)
    }

    fun GetUsersMessagesByDate(location: Int, from: String, index: Int, count: Int, dateFrom: Date, dateTo: Date) {

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
        getXMLResult(RECEIVE_URL, SOAP_ACTION, request)
    }


    //users webservice
    fun GetUserNumbers() {

        val METHOD_NAME = "GetUserNumbers"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun GetUserTransactions(targetUsername: String, creditType: String, keyword: String, dateFrom: Date, dateTo: Date) {

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
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun GetUsers() {

        val METHOD_NAME = "GetUsers"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun HasFilter(text: String) {

        val METHOD_NAME = "HasFilter"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("text", text)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun RemoveUser(targetUsername: String) {

        val METHOD_NAME = "RemoveUser"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun GetProvinces() {

        val METHOD_NAME = "GetProvinces"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun GetCities(provinceId: Int) {

        val METHOD_NAME = "GetCities"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("provinceId", provinceId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun GetExpireDate() {

        val METHOD_NAME = "GetExpireDate"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun AddPayment(name: String, family: String, bankName: String, code: String, amount: Double, cardNumber: String) {

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
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun AuthenticateUser() {

        val METHOD_NAME = "AuthenticateUser"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun ChangeUserCredit(amount: Double, description: String, targetUsername: String, GetTax: Boolean) {

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
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun AuthenticateUser(mobileNumber: String, emailAddress: String, targetUsername: String) {

        val METHOD_NAME = "AuthenticateUser"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("mobileNumber", mobileNumber)
        request.addProperty("emailAddress", emailAddress)
        request.addProperty("targetUsername", targetUsername)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun GetUserBasePrice(targetUsername: String) {

        val METHOD_NAME = "GetUserBasePrice"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun GetUserCredit(targetUsername: String) {

        val METHOD_NAME = "GetUserCredit"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun GetUserDetails(targetUsername: String) {

        val METHOD_NAME = "GetUserDetails"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("targetUsername", targetUsername)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }

    fun GetUserDetails(targetUsername: String, creditType: String, dateFrom: Date, dateTo: Date, keyword: String) {

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
        getXMLResult(USERS_URL, SOAP_ACTION, request)
    }


    //contacts webservice
    fun AddGroup(groupName: String, Descriptions: String, showToChilds: Boolean) {

        val METHOD_NAME = "AddGroup"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("groupName", groupName)
        request.addProperty("Descriptions", Descriptions)
        request.addProperty("showToChilds", showToChilds.toString())

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(CONTACTS_URL, SOAP_ACTION, request)
    }

    fun CheckMobileExistInContact(mobileNumber: String) {

        val METHOD_NAME = "CheckMobileExistInContact"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("mobileNumber", mobileNumber)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(CONTACTS_URL, SOAP_ACTION, request)
    }

    fun GetContacts(groupId: Int, keyword: String, from: Int, count: Int) {

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
        getXMLResult(CONTACTS_URL, SOAP_ACTION, request)
    }

    fun GetGroups() {

        val METHOD_NAME = "GetGroups"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(CONTACTS_URL, SOAP_ACTION, request)
    }

    fun RemoveContact(mobilenumber: String) {

        val METHOD_NAME = "RemoveContact"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("mobilenumber", mobilenumber)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(CONTACTS_URL, SOAP_ACTION, request)
    }

    fun GetContactEvents(contactId: Int) {

        val METHOD_NAME = "GetContactEvents"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("contactId", contactId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(CONTACTS_URL, SOAP_ACTION, request)
    }


    //actions webservice
    fun GetBranchs(owner: Int) {

        val METHOD_NAME = "GetBranchs"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("owner", owner)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun AddBranch(owner: Int, branchName: String) {

        val METHOD_NAME = "AddBranch"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("owner", owner)
        request.addProperty("branchName", branchName)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun AddNumber(branchId: Int, mobileNumbers: Array<String>) {

        val METHOD_NAME = "AddNumber"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        val _numbers = "<string>" + TextUtils.join("</string><string>", mobileNumbers) + "</string>"
        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("branchId", branchId)
        request.addProperty("mobileNumbers", _numbers)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun RemoveBranch(branchId: Int) {

        val METHOD_NAME = "RemoveBranch"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("branchId", branchId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun AddBulk(from: String, branch: Int, bulkType: Byte?, title: String, message: String,
                rangeFrom: String, rangeTo: String, DateToSend: Date, requestCount: Int, rowFrom: Int) {

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
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun GetBulkCount(branch: Int, rangeFrom: String, rangeTo: String) {

        val METHOD_NAME = "GetBulkCount"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("branch", branch)
        request.addProperty("rangeFrom", rangeFrom)
        request.addProperty("rangeTo", rangeTo)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun GetBulkReceptions(bulkId: Int, fromRows: Int) {

        val METHOD_NAME = "GetBulkReceptions"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("bulkId", bulkId)
        request.addProperty("fromRows", fromRows)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun GetBulkStatus(bulkId: Int, sent: Int, failed: Int, status: Byte) {

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
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun GetTodaySent() {

        val METHOD_NAME = "GetTodaySent"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun GetTotalSent() {

        val METHOD_NAME = "GetTotalSent"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun RemoveBulk(bulkId: Int) {

        val METHOD_NAME = "RemoveBulk"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("bulkId", bulkId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun SendMultipleSMS(to: Array<String>, from: String, text: Array<String>, isflash: Boolean, udh: String,
                        recIds: LongArray) {

        val METHOD_NAME = "SendMultipleSMS"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        val _to = "<string>" + TextUtils.join("</string><string>", to) + "</string>"
        val _text = "<string>" + TextUtils.join("</string><string>", text) + "</string>"
        val _recIds = "<long>" + TextUtils.join("</long><long>", setOf(recIds)) + "</long>"
        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("to", _to)
        request.addProperty("from", from)
        request.addProperty("text", _text)
        request.addProperty("isflash", isflash.toString())
        request.addProperty("udh", udh)
        request.addProperty("recId", _recIds)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }

    fun UpdateBulkDelivery(bulkId: Int) {

        val METHOD_NAME = "UpdateBulkDelivery"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("bulkId", bulkId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(ACTIONS_URL, SOAP_ACTION, request)
    }


    //schedule webservice
    fun AddSchedule(to: String, from: String, text: String, isFlash: Boolean, scheduleDateTime: Date,
                    period: String) {

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
        getXMLResult(SCHEDULE_URL, SOAP_ACTION, request)
    }

    fun AddMultipleSchedule(to: Array<String>, from: String, text: Array<String>, isFlash: Boolean, scheduleDateTime: Array<Date>, period: String) {

        val METHOD_NAME = "AddMultipleSchedule"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        val _to = "<string>" + TextUtils.join("</string><string>", to) + "</string>"
        val _text = "<string>" + TextUtils.join("</string><string>", text) + "</string>"
        val _date = "<dateTime>" + TextUtils.join("</dateTime><dateTime>", scheduleDateTime) + "</dateTime>"
        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("from", from)
        request.addProperty("to", _to)
        request.addProperty("text", _text)
        request.addProperty("isflash", isFlash.toString())
        request.addProperty("scheduleDateTime", _date)
        request.addProperty("period", period)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(SCHEDULE_URL, SOAP_ACTION, request)
    }

    fun AddNewUsance(to: String, from: String, text: String, isFlash: Boolean, countrepeat: Int,
                     scheduleEndDateTime: Date, periodType: String) {

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
        getXMLResult(SCHEDULE_URL, SOAP_ACTION, request)
    }

    fun GetScheduleStatus(scheduleId: Int) {

        val METHOD_NAME = "GetScheduleStatus"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("scheduleId", scheduleId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(SCHEDULE_URL, SOAP_ACTION, request)
    }

    fun RemoveSchedule(scheduleId: Int) {

        val METHOD_NAME = "RemoveSchedule"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("scheduleId", scheduleId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(SCHEDULE_URL, SOAP_ACTION, request)
    }


    //voice webservice
    fun GetSendSMSWithSpeechTextStatus(recId: Long) {

        val METHOD_NAME = "GetSendSMSWithSpeechTextStatus"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("recId", recId)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(VOICE_URL, SOAP_ACTION, request)
    }

    fun SendBulkSpeechText(title: String, body: String, receivers: String, DateToSend: String, repeatCount: Int) {

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
        getXMLResult(VOICE_URL, SOAP_ACTION, request)
    }

    fun SendBulkVoiceSMS(title: String, voiceFileId: Int, receivers: String, DateToSend: String, repeatCount: Int) {

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
        getXMLResult(VOICE_URL, SOAP_ACTION, request)
    }

    fun SendSMSWithSpeechText(smsBody: String, speechBody: String, from: String, to: String) {

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
        getXMLResult(VOICE_URL, SOAP_ACTION, request)
    }

    fun SendSMSWithSpeechTextBySchduleDate(smsBody: String, speechBody: String, from: String, to: String,
                                           scheduleDate: Date) {

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
        getXMLResult(VOICE_URL, SOAP_ACTION, request)
    }

    fun UploadVoiceFile(title: String, base64StringFile: String) {

        val METHOD_NAME = "UploadVoiceFile"
        val request = SoapObject(NAMESPACE, METHOD_NAME)

        //Use this to add parameters
        request.addProperty("username", Username)
        request.addProperty("password", Password)
        request.addProperty("title", title)
        request.addProperty("base64StringFile", base64StringFile)

        val SOAP_ACTION = NAMESPACE + METHOD_NAME
        getXMLResult(VOICE_URL, SOAP_ACTION, request)
    }

    companion object {

        private val NAMESPACE = "http://tempuri.org/"
        private val SEND_URL = "http://api.payamak-panel.com/post/send.asmx"
        private val RECEIVE_URL = "http://api.payamak-panel.com/post/receive.asmx"
        private val USERS_URL = "http://api.payamak-panel.com/post/Users.asmx"
        private val CONTACTS_URL = "http://api.payamak-panel.com/post/contacts.asmx"
        private val ACTIONS_URL = "http://api.payamak-panel.com/post/actions.asmx"
        private val SCHEDULE_URL = "http://api.payamak-panel.com/post/Schedule.asmx"
        private val VOICE_URL = "http://api.payamak-panel.com/post/Voice.asmx"

        private val TAG = "melipayamak"
    }

}


class MPTaskParams(var url: String, var soapAction: String, var request: SoapObject)