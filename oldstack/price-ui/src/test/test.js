let newOrderMap = new Map();
newOrderMap.set("aa","1");
newOrderMap.set("bb","2");
newOrderMap.set("cc","3");
newOrderMap.forEach((value, key) => {
	console.log("key:"+key);
	console.log("value:"+value);
});


var images = new Array(
	"images/website1.jpg",
	"images/website2.jpg",
	"images/website3.jpg"
  );

//setTimeout(function() { delay(images, 0); }, 1000);

function delay(arr, num) {
  if (arr[num]){
	console.log("image:"+arr[num]);
  	setTimeout(function() { delay(arr, num + 1); }, 1000);
  }
}

class WebSocketService {
  constructor() {
		console.log("constructor");
    this.reconnectTimes = 0;
		this.MAX_RECONNECT_TIME = 10;
		this.onConnect = this.onConnect.bind(this);
	}

	connect() {
		console.log("connect");
    setTimeout(this.onConnect , 1000);
	}
	onConnect(){
		console.log("on connect");
		//console.log(this);
		if (this.reconnectTimes < this.MAX_RECONNECT_TIME) {
				console.log("this.reconnectTimes:"+this.reconnectTimes);
				this.connect();
				// setTimeout((function() { this.connect() }).bind(this), 1000);
				this.reconnectTimes++;
		}
	}
}
const socket = new WebSocketService();
socket.connect();
