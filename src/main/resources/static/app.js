var stompClient = null;

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, 
    		JSON.stringify({}));
}

function showGreeting(message) {
	document.getElementById("conversation").rows[1].cells[0].innerHTML = message.computernameInfo;
	document.getElementById("conversation").rows[1].cells[1].innerHTML = message.processornameInfo;
	document.getElementById("conversation").rows[1].cells[2].innerHTML = message.ipaddressInfo;
	document.getElementById("conversation").rows[1].cells[3].innerHTML = message.currentUserInfo;
	document.getElementById("conversation").rows[1].cells[4].innerHTML = message.physicalMemoryInfo;
	document.getElementById("conversation").rows[1].cells[5].innerHTML = message.freephysicalMemoryInfo;
	document.getElementById("conversation").rows[1].cells[6].innerHTML = message.freephysicalMemoryPercentageInfo;
	document.getElementById("conversation").rows[1].cells[7].innerHTML = message.cDriveCapacityInfo;
	document.getElementById("conversation").rows[1].cells[8].innerHTML = message.cfreePartitionSpaceInfo;
	document.getElementById("conversation").rows[1].cells[9].innerHTML = message.dDriveCapacityInfo;
	document.getElementById("conversation").rows[1].cells[10].innerHTML = message.dfreePartitionSpaceInfo;
	document.getElementById("conversation").rows[1].cells[11].innerHTML = message.eDriveCapacityInfo;
	document.getElementById("conversation").rows[1].cells[12].innerHTML = message.efreePartitionSpaceInfo;
	document.getElementById("conversation").rows[1].cells[13].innerHTML = message.cpuUsageInfo;
	document.getElementById("conversation").rows[1].cells[14].innerHTML = message.currentTemperatureInfo;
	document.getElementById("conversation").rows[1].cells[15].innerHTML = message.date;
}

window.onload = function() {
	connect();
	setInterval(function() {
		sendName();
		}, 1000);
	};

$(function () {
    $( "#disconnect" ).click(function() { disconnect(); });
});