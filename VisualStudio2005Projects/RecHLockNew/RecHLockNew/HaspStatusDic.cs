using System;
using System.Collections.Generic;
using System.Text;

namespace RecHLockNew
{
    class MapaStatus
    {

        private Dictionary<int, string> mapaStatus = null;

        public MapaStatus()
        {
            mapaStatus = new Dictionary<int, string>();

            mapaStatus.Add(0, "Success.");
            mapaStatus.Add(1, "Invalid memory address.");
            mapaStatus.Add(2, "Unknown/invalid feature id option.");
            mapaStatus.Add(3, "Memory allocation failed.");
            mapaStatus.Add(4, "Too many open features.");
            mapaStatus.Add(5, "Feature access denied.");
            mapaStatus.Add(6, "Incompatible feature.");
            mapaStatus.Add(7, "Sentinel key not found.");
            mapaStatus.Add(8, "En-/decryption length too short.");
            mapaStatus.Add(9, "Invalid handle.");
            mapaStatus.Add(10, "Invalid file id / memory descriptor.");
            mapaStatus.Add(11, "Driver or support daemon version too old.");
            mapaStatus.Add(12, "Real time support not available.");
            mapaStatus.Add(13, "Generic error from host system call.");
            mapaStatus.Add(14, "Hardware key driver not found.");
            mapaStatus.Add(15, "Unrecognized info format.");
            mapaStatus.Add(16, "Request not supported.");
            mapaStatus.Add(17, "Invalid update object.");
            mapaStatus.Add(18, "Key with requested id was not found.");
            mapaStatus.Add(19, "Update data consistency check failed.");
            mapaStatus.Add(20, "Update not supported by this key.");
            mapaStatus.Add(21, "Update counter mismatch.");
            mapaStatus.Add(22, "Invalid vendor code.");
            mapaStatus.Add(23, "Requested encryption algorithm not supported.");
            mapaStatus.Add(24, "Invalid date / time.");
            mapaStatus.Add(25, "Clock out of power.");
            mapaStatus.Add(26, "Update requested ack., but no area to return it.");
            mapaStatus.Add(27, "Terminal services (remote terminal) detected.");
            mapaStatus.Add(28, "Feature type not implemented.");
            mapaStatus.Add(29, "Unknown algorithm.");
            mapaStatus.Add(30, "Signature check failed.");
            mapaStatus.Add(31, "Feature not found");
            mapaStatus.Add(32, "Trace log not enabled.");
            mapaStatus.Add(33, "Communication error between application and local LM");
            mapaStatus.Add(34, "Vendor code unknown to API library (run apigen to make it known)");
            mapaStatus.Add(35, "Invalid XML spec");
            mapaStatus.Add(36, "Invalid XML scope");
            mapaStatus.Add(37, "Too many keys connected");
            mapaStatus.Add(38, "Too many users");
            mapaStatus.Add(39, "Broken session");
            mapaStatus.Add(40, "Communication error between local and remote LM");
            mapaStatus.Add(41, "The feature is expired");
            mapaStatus.Add(42, "Sentinel LM version too old");
            mapaStatus.Add(43, "Sentinel SL secure storage I/O error or USB request error");
            mapaStatus.Add(44, "Update installation not allowed");
            mapaStatus.Add(45, "System time has been tampered");
            mapaStatus.Add(46, "Secure channel communication error");
            mapaStatus.Add(47, "Secure storage contains garbage");
            mapaStatus.Add(48, "Vendor lib cannot be found");
            mapaStatus.Add(49, "Vendor lib cannot be loaded");
            mapaStatus.Add(50, "No feature matching scope found");
            mapaStatus.Add(51, "Virtual machine detected");
            mapaStatus.Add(52, "Sentinel update incompatible with this hardware; Sentinel key is locked to other hardware");
            mapaStatus.Add(53, "Login denied because of user restrictions");
            mapaStatus.Add(54, "Update was already installed");
            mapaStatus.Add(55, "Another update must be installed first");
            mapaStatus.Add(56, "Vendor library version too old");
            mapaStatus.Add(57, "Upload error");
            mapaStatus.Add(58, "Invalid XML recipient parameter for hasp_detach");
            mapaStatus.Add(59, "Invalid XML action parameter for hasp_detach");
            mapaStatus.Add(60, "Scope for hasp_detach does not select a unique Product");
            mapaStatus.Add(61, "Invalid Product information");
            mapaStatus.Add(62, "Unknown Recipient");
            mapaStatus.Add(63, "Invalid Duration");
            mapaStatus.Add(64, "Clone Detected");
            mapaStatus.Add(65, "Update Already Added");
            mapaStatus.Add(66, "Hasp Inactive");
            mapaStatus.Add(67, "No Detachable Feature");
            mapaStatus.Add(68, "Too Many Hosts");
            mapaStatus.Add(69, "Rehost Not Allowed");
            mapaStatus.Add(70, "License Rehosted");
            mapaStatus.Add(71, "Rehost Already Applied");
            mapaStatus.Add(72, "Cannot Read File");
            mapaStatus.Add(400, "A required API dynamic library was not found");
            mapaStatus.Add(401, "The found and assigned API dynamic library could not be verified");
            mapaStatus.Add(500, "Calling invalid object.");
            mapaStatus.Add(501, "A parameter is invalid.");
            mapaStatus.Add(502, "Already logged in.");
            mapaStatus.Add(503, "Already logged out.");
            mapaStatus.Add(525, "Unable to excecute/complete the operation.");
            mapaStatus.Add(600, "No classic memory extension block available.");
            mapaStatus.Add(650, "Invalid port type.");
            mapaStatus.Add(651, "Invalid port.");
            mapaStatus.Add(652, "HASP Dot Net Dll Broken");
            mapaStatus.Add(698, "Capability is not available.");
            mapaStatus.Add(699, "Internal API error.");
        }

        public string getStatus(int status)
        {
            return mapaStatus[status];
        }

    }
}
