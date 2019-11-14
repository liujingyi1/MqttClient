package com.android.client.mqttclient2;

public class MqttTopics {
    /**
     * From server to client
     */
    public static final String DISPATCH_FILTER_ITEM = "/server/dispatchFilterItem/";
    public static final String DISPATCH_FILTER_LIST = "/server/dispatchFilterList/";
    public static final String SIP_ITEM = "/server/sipItem/";
    public static final String SIP_ITEM_LIST = "/server/sipItemList/";
    public static final String SIP_CONFIG_INFO = "/server/sipConfigInfo/";
    public static final String DISPATCH_OTP = "/server/dispatchOTP/";
    public static final String UPGRADE_REQUEST = "/server/upgradeRequest/";
    public static final String DEVICE_CONTROL_REQUEST = "/server/deviceControlRequest/";
    public static final String FACE_ADD = "/server/faceAdd/";
    public static final String FACE_DELETE = "/server/faceDelete/";

    /**
     * From client to server
     */
    public static final String UPLOAD_ACCESS_LOG = "/client/uploadAccessLog/";
    public static final String UPLOAD_DOOR_SENSOR = "/client/uploadDoorSensor/";
    public static final String UPLOAD_DEVICE_INFO = "/client/uploadDeviceInfo/";
    public static final String UPLOAD_DEVICE_EVENT = "/client/uploadDeviceEvent/";
    public static final String UPLOAD_DEVICE_MAINTAIN = "/client/uploadDeviceMaintain/";
}
