<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.conducterVideo {
	border: 1px solid black;
	background-image:
		url("${context}/resources/image/remote_video_mini.png");
	background-repeat: no-repeat;
	width: 248px;
	height: 198px;
}

.remoteVideo {
	border: 1px solid black;
	background-image:
		url("${context}/resources/image/remote_video_mini2.png");
	background-repeat: no-repeat;
	width: 202px;
	height: 152px;
}

.localVideo {
	border: 1px solid black;
	background-image:
		url("${context}/resources/image/local_video_mini2.png");
	background-repeat: no-repeat;
	width: 202px;
	height: 152px;
}

.operater {
	position: absolute;
	margin-left: 5px;
	margin-top: 5px;
}

.hiddenCheckBox {
	/* display: none;*/
	background: url(${context}/resources/image/CheckBox.gif) 0px -300px
		no-repeat;
	display: block;
	width: 16px;
	height: 16px;
	display: inline-block;
	vertical-align: top;
	margin-left: -80px;
}

.chkTerm {
	position: absolute;
	margin-left: -15px;
	margin-top: 5px;
}

.divTerm {
	min-height: 110px;
	max-width: 110px;
	width: 100px;
	cursor: pointer;
}
</style>
<h4>协同指挥操作台</h4>

<!-- 终端列表  -->
<div style="min-width: 770px;">
	<div class="alert alert-info">
		<strong>温馨提示：</strong><span id="txtTishi">正在处理中......</span><br /> <label
			class="radio inline"> <input type="radio"
			name="optionsRadios" id="rAll" value="all" onclick="getTerms(-3)">全部
		</label> <label class="radio inline"> <input type="radio"
			name="optionsRadios" id="rIdle" value="reg" onclick="getTerms(-1)">空闲
		</label> <label class="radio inline"> <input type="radio"
			name="optionsRadios" id="rBusy" value="busy" onclick="getTerms(0)">通话中
		</label> <label class="radio inline"> <input type="radio"
			name="optionsRadios" id="rUnregister" value="unreg"
			onclick="getTerms(-2)">未注册
		</label>
	</div>
	<div class="modal-body" style="height: 310px;">
		<div class="row-fluid text-center" id="termList">
			<c:forEach var="term" items="${termList}" varStatus="status">
				<c:if
					test="${termId != fn:substring(term.peer,4,fn:length(term.peer) )}">
					<div class="span5 divTerm"
						style="<c:if test="${status.count==1}">margin-left: 25px;</c:if>"
						id="divTerm_${term.peer }"
						onclick="selPhone('${term.peer }', ${term.channelState })">
						<div id="border_${term.peer }"
							style="border: 2px
						<c:choose>
									<c:when test="${term.channelState==-2}">gray</c:when>
									<c:when test="${term.channelState==-1}">blue</c:when>
									<c:when test="${term.channelState==5}">yellow</c:when>
									<c:when test="${term.channelState==4}">yellow</c:when>
									<c:otherwise>red</c:otherwise>
								</c:choose> 
						solid; border-radius: 10px;">
							<span class="hiddenCheckBox" id="span_${term.peer }"> <input
								name="termChk" type="checkbox" id="${term.peer }"
								style="display: none;" /></span> <img src=""
								onclick="sel_chk(this, '${term.peer }')" class="chkTerm" />
							<div class="mini-layout fluid">
								<div class="mini-layout-sidebar">
									<img src="${context}/resources/img/phone_unregister.png"
										style="width: 40px; height: 40px;">
								</div>
								<div class="mini-layout-body">
									${term.peer }<br>状态： <span id="state_${term.peer}">
										<c:choose>
											<c:when test="${term.channelState==-2}">未注册</c:when>
											<c:when test="${term.channelState==-1}">空闲</c:when>
											<c:when test="${term.channelState==5}">振铃中</c:when>
											<c:when test="${term.channelState==4}">呼叫中</c:when>
											<c:otherwise>忙</c:otherwise>
										</c:choose>
									</span>
								</div>
							</div>
						</div>
						<div style="height: 5px;"></div>
					</div>
				</c:if>
			</c:forEach>


		</div>
	</div>
	<div class="row modal-footer">
		<div class="text-left span4" style="line-height: 30px;width:100px;">
			
			<input type="checkbox" class="text-left" style="margin-top: -3px;display:none;"
				id="selAll" /><!-- 全选 --> <a href="javascript:clear();"
				class="btn btn-primary">清除</a>
		</div>
		<div class="text-right span8 offset2" style="min-width:616px;">
			<button id="btnRegister" onclick="javascript:register();"
				class="btn btn-primary">注册</button>
			<button id="btnMonitor" onclick="javascript:monitor();"
				class="btn btn-primary" disabled>监听</button>
			<button id="btnInsert" onclick="javascript:insert();"
				class="btn btn-primary" disabled>强插</button>
			<button id="btnDismantle" onclick="javascript:dismantle();"
				class="btn btn-primary" disabled>强拆</button>
			<button id="btnSecrect" onclick="javascript:secrect();"
				class="btn btn-primary" disabled>密语</button>
			<button id="btnInstead" onclick="javascript:instead();"
				class="btn btn-primary" disabled>代接</button>

			<button id="btnVideoCall" onclick="javascript:makeVideoCall();"
				class="btn btn-primary" disabled>视频呼叫</button>
			<button id="btnAudioCall" onclick="javascript:makeAudioCall();"
				class="btn btn-primary" disabled>音频呼叫</button>

			<button id="btnAbort" onclick="javascript:hangup();"
				class="btn btn-danger" disabled>终止</button>
			<input type="hidden" id="calledNumber" placeholder="请输入呼叫号码">
		</div>
	</div>
</div>
<!-- 消息提示框  -->

<div class="modal hide fade" id="videoCallModal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h3>视频呼叫</h3>
	</div>
	<div class="modal-body form-horizontal">
		<div class="row-fluid text-center">
			<div class="span5 offset1">
				<video id="video_local" class="localVideo"
					style="width: 200px; height: 150px"></video>
			</div>
			<div class="span5">
				<video id="video_remote" class="remoteVideo"
					style="width: 200px; height: 150px"></video>
			</div>
		</div>

	</div>
	<div class="modal-footer">
		<a href="javascript:hangup();" id="saveUserBtn" class="btn btn-danger">挂机</a>
	</div>
</div>
<script type="text/javascript"
	src="${context }/resources/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript">
	//var lastSelTerm = "";
	function clear() {
		var ts = document.getElementsByName("termChk");
		//debugger;
		for (var i = 0; i < ts.length; i++) {
			ts[i].checked = false;

			document.getElementById("span_" + ts[i].id).style.background = "url(${context}/resources/image/CheckBox.gif) 0px -300px no-repeat";
		}
	}
	function getTerms(chState) {
		var channelState = "=" + chState;
		if (chState == 0) {
			channelState = ">=0";
		} else if (chState == -3) {
			channelState = ">-3";
		}

		var url = "${context}/term/search";
		$
				.post(
						url,
						{
							status : channelState,
						},
						function(result, status) {
							//debugger;
							if (status == 'success') {
								var termSates = eval(result);
								//debugger;
								var strTermList = "";
								for (var i = 0; termSates != null && i < termSates.length; i++) {
									var peer = termSates[i].Peer;
									var state = termSates[i].ChannelState;
									var pos = -300;
									//var state_img = "";
									var state_color;
									var state_str = "未注册";
									if (parseInt(state) == -2) {
										state_str = "未注册";
										state_color = "gray";
									} else if (parseInt(state) == -1) {
										state_str = "空闲";
										state_color = "blue";
									} else if (parseInt(state) == 4
											|| parseInt(state) == 5) {
										state_str = "振铃中";
										state_color = "yellow";
									} else {
										state_color = "red";
										state_str = "忙";
									}
									strTermList += "<div class=\"span5 divTerm\" id=\"divTerm_"+ peer +"\" style=\"margin-left: 25px;\" onclick=\"selPhone('"
											+ peer + "',"+ state +")\">";
									strTermList += '<div id="border_'+peer+'" style="border: 2px solid '+state_color+'; border-radius: 10px;">';
									strTermList += '<span class="hiddenCheckBox" id="span_'
											+ peer
											+ '" style="background: url(${context}/resources/image/CheckBox.gif) 0px '
											+ pos + 'px no-repeat;">';
									strTermList += '<input name="termChk" type="checkbox" id="'+peer+'" style="display: none;"></span>';
									strTermList += "<img src=\"\" onclick=\"sel_chk(this, '"
											+ peer + "')\" class=\"chkTerm\">";
									strTermList += '<div class="mini-layout fluid">';
									strTermList += '<div class="mini-layout-sidebar">';
									strTermList += '<img src="${context}/resources/img/phone_unregister.png" style="width: 40px; height: 40px;"></div>';
									strTermList += '<div class="mini-layout-body">';
									strTermList += peer
											+ '<br>状态： <span id="state_'+peer+'">'+state_str+'</span>';
									strTermList += '</div></div></div><div style="height: 5px;"></div></div>';
								}
								document.getElementById("termList").innerHTML = strTermList;
							}

						});
	}
	function selPhone(chkId, state) {
		if(parseInt(state)<-1){
			alert("对不起，该终端未注册，不能进行任何操作！");
			return;
		}
		if(parseInt(state)==4){
			alert("对不起，该终端是主叫振铃，不能进行任何操作！");
			return;
		}
		var termList = document.getElementsByName("termChk");
		
		//清除其他的选项，
		for (var i = 0; i < termList.length; i++) {
			if(termList[i].checked){
				document.getElementById(termList[i].id).checked = false;
				var spanObj0 = document.getElementById("span_" + termList[i].id);
				spanObj0.style.background = "url(${context}/resources/image/CheckBox.gif) 0px -300px no-repeat";
			}
		}
		//debugger;
			//设置当前选中的终端
		var chkObj = document.getElementById(chkId);
		chkObj.checked = !chkObj.checked;
		var spanObj = document.getElementById("span_" + chkId);
		if (chkObj.checked) {
			//保存最后一次选中的终端
			calledNumber.value = chkId.substr(4);
			spanObj.style.background = "url(${context}/resources/image/CheckBox.gif) 0px -450px no-repeat";
		} else {
			spanObj.style.background = "url(${context}/resources/image/CheckBox.gif) 0px -300px no-repeat";
		}
		
		//按钮设置
		setFuntionBtn(chkId);
	}
	function setFuntionBtn(chkId) {

		btnMonitor.disabled=true;//监听
		btnInsert.disabled=true;//强插
		btnDismantle.disabled=true;//强拆
		btnSecrect.disabled=true;//密语
		btnInstead.disabled=true;//代接
		btnVideoCall.disabled=true;//视频呼叫
		btnAudioCall.disabled=true;//音频呼叫
		btnAbort.disabled=true;//终端
		//debugger;
		//根据状态打开不同的按钮
		var termList = document.getElementsByName("termChk");
				var terms = "";
				for (var i = 0; i < termList.length; i++) {
					if(termList[i].checked){
					terms += termList[i].id + ",";
					}
				}
		//debugger;
		if(terms.length==0) return;
		var url = "${context}/term/search";
		$.post(url, {
			peers : terms,
		}, function(result, status) {
			//debugger;
			if (status == 'success') {
				var termSates = eval(result);
				//debugger;
				var idle = 0;
				var ring = 0;
				var busy = 0;
				var unreg = 0;
				for (var i = 0; i < termSates.length; i++) {
					var state = termSates[i].ChannelState;
					if(parseInt(state)<=-2){
						unreg++;
					}
					else if(parseInt(state)==-1){
						idle++;
					}
					else if(/*parseInt(state)==4 ||*/ parseInt(state)==5 ){
					ring++;
					}
					else if( parseInt(state)==4 ){
						
					}
					else{
					busy++;
					}
				}//end for
				//debugger;
				if(ring>0){
					btnInstead.disabled=false;//代接
				}
				else if(busy>0){
					btnAbort.disabled = false;//z终止呼叫
					btnMonitor.disabled=false;//监听
					btnInsert.disabled=false;//强插
					btnDismantle.disabled=false;//强拆
					btnSecrect.disabled=false;//密语
					
				}
				else if(idle>0){
					btnVideoCall.disabled=false;//视频呼叫
					btnAudioCall.disabled=false;//音频呼叫
				}
				

			}

		});
	}
	function setTermSate(peer, state) {
		//debugger;
		var peerObj = document.getElementById("border_" + peer);
		var peerStateObj = document.getElementById("state_" + peer);
		//debugger;
		var tObj  = document.getElementById("divTerm_"+peer);
		if(tObj == null){
			return;
		}
		tObj.onclick=function(){
			selPhone(peer, state);
		}
		if (parseInt(state) == 4 || parseInt(state) == 5) {
			//振铃中
			//debugger;
			//console.log("set " + peer + " is ring.");
			peerObj.style.borderColor = "yellow";
			peerStateObj.innerHTML = "振铃中";
		} else if (parseInt(state) == -1) {
			//空闲
			//console.log("set " + peer + " is idle.");
			peerObj.style.borderColor = "blue";
			peerStateObj.innerHTML = "空闲";
		} else if (parseInt(state) == -2) {
			//未注册
			//console.log("set " + peer + " is unregister.");
			peerObj.style.borderColor = "gray";
			peerStateObj.innerHTML = "未注册";
		} else {
			//console.log("set " + peer + " is busy.");
			peerObj.style.borderColor = "red";
			peerStateObj.innerHTML = "忙";
		}
	}
	function sel_chk(imgChkObj, chkId) {
		//	do
		//	imgChkObj.
	}
	function call(id) {
		termId.value = id;
		$("#callModal").modal("show");
	}

	function mouseout(event, obj, id) {
		//发生闪烁现象
		var from = event.relatedTarget ? event.relatedTarget
				: event.fromElement;
		var to = event.target ? event.target : event.toElement;
		//alert("from:" + from.tagName + ";to:" + to.tagName);

		if (from.tagName == "DIV"
				|| (from.tagName == "VIDEO" && to.tagName == "VIDEO"))
			document.getElementById("op_" + id).style.display = "none";
	}
	function mouseover(event, obj, id) {
		//发生闪烁现象
		var from = event.relatedTarget ? event.relatedTarget
				: event.fromElement;
		var to = event.target ? event.target : event.toElement;
		//if(obj.tagName=="VIDEO")
		document.getElementById("op_" + id).style.display = "";
	}

	function setStateUpdateTimer() {
		stateTimer = setInterval(function() {
			console.log("-------- set timer to refresh term state. -------");
			if (document.readyState == "complete") {
				//获取状态
				//console.log("refresh term state!");

				//获取终端列表
				var termList = document.getElementsByName("termChk");
				var terms = "";
				for (var i = 0; i < termList.length; i++) {
					terms += termList[i].id + ",";
				}
				//debugger;
				var url = "${context}/term/search";
				$.post(url, {
					peers : terms,
				}, function(result, status) {
					//debugger;
					if (status == 'success') {
						var termSates = eval(result);
						//debugger;
						for (var i = 0; i < termSates.length; i++) {
							setTermSate(termSates[i].Peer,
									termSates[i].ChannelState);
						}

					}

				});

			}
		}, 3 * 1000);
	}
	
	function monitor(){
		funName = "监听";
		audioCall("33"+calledNumber.value);
	}
	function insert(){
		funName = "强插";
		audioCall("11"+calledNumber.value);
	}
	function dismantle(){
		funName = "强拆";
		audioCall("22"+calledNumber.value);
	}
	function secrect(){
		funName = "密语";
		audioCall("44"+calledNumber.value);
	}
	function instead(){
		funName = "代接";
		audioCall("*8"+calledNumber.value);
	}
	function makeVideoCall(){
		funName = "视频呼叫";
		//弹出视频窗口
		$("#videoCallModal").modal("show");
		//发起呼叫
		videoCall(calledNumber.value);
		
	}
	function makeAudioCall(){
		funName = "呼叫";
		audioCall(calledNumber.value);
		
	}
		

</script>
<style>
.localVideo {
	border: 1px solid black;
	/*background-image: url("${context}/resources/image/local_video.png");
	background-repeat: no-repeat;
	*/
	width: 124px;
	height: 93px;
}

.remoteVideo {
	border: 1px solid black;
	/*background-image: url("${context}/resources/image/remote_video.png");
	background-repeat: no-repeat;
	*/
	width: 124px;
	height: 93px;
}
</style>

<!-- 呼叫控制部分开始 -->
<audio id="audio_remote" autoplay="autoplay"></audio>
<audio id="ringtone" loop
	src="${context }/resources/sipml5/sounds/ringtone.wav"></audio>
<audio id="ringbacktone" loop
	src="${context }/resources/sipml5/sounds/ringbacktone.wav"></audio>
<script type="text/javascript">
	var impi = "${termId}";
	var webRoot = "${context}";
</script>
<script src="${context}/resources/sipml5/SIPml-api.js?svn=224"
	type="text/javascript">
	//
</script>
<script src="${context}/resources/sipml5/SIPml.js"
	type="text/javascript">
	//SIPml5基本类库
</script>
<script type="text/javascript"
	src="${context}/resources/sipml5/SIPml5-audio.js">
	//UA/UE侧控制
</script>
<script type="text/javascript">
	
</script>
<!-- 呼叫控制部分结束 -->