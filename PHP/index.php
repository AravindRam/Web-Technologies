<html>
	<head>
		<style type="text/css">
			.layout{
				border:2px solid;
			}
			.entries{
				position:relative;
				margin-left:62px;
				left:60px;
				margin-top:-20px;
			}
			#inner{
				margin-left:10px;
				margin-right:10px;
				margin-bottom:10px;
				margin-top:-15px;
			}
			#outer{
				margin-left:400px;
				margin-right:470px;
				margin-top:20px;
			}
			#image{
				margin-left:250px;
			}
			#shopping{
				position:absolute;
				margin-left:335px;
				top:40px;
			}
			#fields{
				margin-left:10px;
				margin-top:10px;
				margin-right:10px;
			}
			#buttons{
				margin-left:430px;
				padding-bottom:20px;
			}
			#output_outer{
				margin-left:350px;
				margin-right:420px;
				margin-top:10px;
				padding-top:5px;
				border:2px solid;
			}
			#output_inner{
				margin-left:10px;
				margin-right:10px;
				margin-bottom:10px;
				margin-top:-10px;
				border:1px solid
			}
			#no_output{
				margin-left:400px;
				margin-right:470px;
				margin-top:0.5px;
				padding-top:5px;
				border:2px solid;
			}
			#output_header{
				margin-left:250px;
			}
			a{
				display:block;
				font-size:10.5px;
				width:470px;
			}
			#output_outer td{
				font-size:11px;
			}
			#condi{
				margin-top:30px;
			}
			#rating1{
				margin-left:80px;
				margin-top:-40px;
			}
			#rating2{
				margin-left:110px;
				margin-top:-40px;
			}
			#rating3{
				margin-left:135px;
				margin-top:-40px;
			}
			#resultTable{
				margin-top:-40px;
			}
		</style>
	</head>
	<body>
		<div class="layout" id="outer">
			<p><div><img id="image" src="http://cs-server.usc.edu:45678/hw/hw6/ebay.jpg" width="80px" height="80px" /><h2 id="shopping">Shopping</h2></div></p><br />
			<div class="layout" id="inner">
				<div id="fields">
				  <form id="myform" action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
					 <table id='formTable' border="0" cellpadding="0" cellspacing="0">
					<tr><td><b>Key Words*:</b>	<div class="entries">																																																																																		
											<input type="text" id="Keywords" name="keywords" size="75" value="<?php if(isset($_POST['keywords'])) echo $_POST['keywords'] ?>" />
										</div><hr /></td></tr>
					<tr><td><b>Price Range:</b> <div class="entries">
											from $ <input type="text" id="From" name="from" size="10" value="<?php if(isset($_POST['from'])) echo $_POST['from'] ?>" /> 
											to $ <input type="text" id="To" name="to" size="10" value="<?php if(isset($_POST['to'])) echo $_POST['to'] ?>" />
									</div><hr /></td></tr>
					<tr><td><b>Condition:</b> 	<div class="entries">
											<input type="checkbox" id="New" name="condition[]" value="1000" <?php if (isset($_POST['condition']) && in_array("1000" , $_POST['condition'])) echo "checked";?> />New
				 						<input type="checkbox" id="Used" name="condition[]" value="3000" <?php if (isset($_POST['condition']) && in_array("3000" , $_POST['condition'])) echo "checked";?> />Used
											<input type="checkbox" id="VGood" name="condition[]" value="4000" <?php if (isset($_POST['condition']) && in_array("4000" , $_POST['condition'])) echo "checked";?> />Very Good
											<input type="checkbox" id="Good" name="condition[]" value="5000" <?php if (isset($_POST['condition']) && in_array("5000" , $_POST['condition'])) echo "checked";?> />Good
											<input type="checkbox" id="Acceptable" name="condition[]" value="6000" <?php if (isset($_POST['condition']) && in_array("6000" , $_POST['condition'])) echo "checked";?> />Acceptable
										</div><hr /></td></tr>
					<tr><td><b>Buying Formats:</b>	<div class="entries">
												<input type="checkbox" id="Buy" name="buying[]" value="FixedPrice" <?php if (isset($_POST['buying']) && in_array("FixedPrice" , $_POST['buying'])) echo "checked";?> />Buy It Now
												<input type="checkbox" id="Auction" name="buying[]" value="Auction" <?php if (isset($_POST['buying']) && in_array("Auction" , $_POST['buying'])) echo "checked";?> />Auction
												<input type="checkbox" id="Ads" name="buying[]" value="Classified" <?php if (isset($_POST['buying']) && in_array("Classified" , $_POST['buying'])) echo "checked";?> />Classified Ads
											</div><hr /></td></tr>
					<tr><td><b>Seller:</b> 	<div class="entries">
												<input type="checkbox"  id="Seller" name="returnsAcceptedOnly" value="true" <?php if (isset($_POST['returnsAcceptedOnly'])) echo "checked";?> />Return accepted
											</div><hr /></td></tr>
					<tr><td><b>Shipping:</b> <div class="entries">
										<input type="checkbox" id="Free" name="shippingFree" value="true" <?php if (isset($_POST['shippingFree'])) echo "checked";?> />Free Shipping<br />
										<input type="checkbox" id="Expedited" name="shippingExpedited" value="Expedited" <?php if (isset($_POST['shippingExpedited'])) echo "checked";?> />Expedited shipping available<br />
										Max handling time (days): <input type="text" id="Days" name="days" size="10" value="<?php if(isset($_POST['days'])) echo $_POST['days'] ?>" /><br />
									 </div><hr /></td></tr>
					<tr><td><b>Sort by:</b> 
									<div class="entries">
										<select id="Sort" name="sort">
											<option value="Best Match" <?php if (isset($_POST['sort']) && $_POST['sort']=="Best Match") echo "selected";?> >Best Match</option>
											<option value="CurrentPriceHighest" <?php if (isset($_POST['sort']) && $_POST['sort']=="CurrentPriceHighest") echo "selected";?> >Price: highest first</option>
											<option value="PricePlusShippingHighest" <?php if (isset($_POST['sort']) && $_POST['sort']=="PricePlusShippingHighest") echo "selected";?> >Price + Shipping: highest first</option>
											<option value="PricePlusShippingLowest" <?php if(isset($_POST['sort']) && $_POST['sort']=="PricePlusShippingLowest") echo "selected";?> >Price + Shipping: lowest first</option>
										</select><br />
									</div><hr /></td></tr>
					<tr><td><b>Results Per Page:</b>
												<div class="entries">
													<select id="Result" name="result">
														<option value="5" <?php if (isset($_POST['result']) && $_POST['result']=="5") echo "selected";?> >5</option>
														<option value="10" <?php if (isset($_POST['result']) && $_POST['result']=="10") echo "selected";?> >10</option>
														<option value="15" <?php if (isset($_POST['result']) && $_POST['result']=="15") echo "selected";?> >15</option>
														<option value="20" <?php if (isset($_POST['result']) && $_POST['result']=="20") echo "selected";?> >20</option>
													</select><br />
												</div></td></tr>
				<tr><td><div id="buttons">
						<input type="button" name="clear" value="clear" style="width:75px" onclick="clearForm()" />
						<input type="submit" name="search" value="search" style="width:75px" onclick="query()" />
					</div></td></tr>
					</table>
				  </form>	
				</div>
			</div>
		</div>
		
		<?php
			$host = "http://svcs.ebay.com/services/search/FindingService/v1?";  
			$responseDataFormat = "XML";   
			$version = "1.0.0";
			$appID   = <your-appId>
			$result = "";
			$numItems=0;
			$numValues=0;
			
			$APIRequestURL  =  $host
							  ."siteid=0"
							  ."&SECURITY-APPNAME=".$appID
							  ."&OPERATION-NAME=findItemsAdvanced"
							  ."&SERVICE-VERSION=".$version
							  ."&RESPONSE-DATA-FORMAT=".$responseDataFormat;
			
			if(isset($_POST['keywords'])){		
				$APIRequestURL.="&keywords=".urlencode($_POST['keywords']);
			}
			
			if(isset($_POST['from']) && $_POST['from']!=""){
				$APIRequestURL.="&itemFilter(".$numItems.").name=MinPrice"."&itemFilter(".$numItems.").value=".$_POST['from'];
				$numItems++;
			}
			if(isset($_POST['to']) && $_POST['to']!=""){
				$APIRequestURL.="&itemFilter(".$numItems.").name=MaxPrice"."&itemFilter(".$numItems.").value=".$_POST['to'];
				$numItems++;
			}
			
			
			if (isset($_POST['condition'])){
				
				$APIRequestURL.="&itemFilter(".$numItems.").name=Condition";
			
				if (in_array("1000" , $_POST['condition'])){
					$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=1000";
					$numValues++;
				}
				if (in_array("3000" , $_POST['condition'])){
					$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=3000";
					$numValues++;
				}
				if (in_array("4000" , $_POST['condition'])){
					$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=4000";
					$numValues++;
				}
				if (in_array("5000" , $_POST['condition'])){
					$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=5000";
					$numValues++;
				}
				if (in_array("6000" , $_POST['condition'])){
					$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=6000";
					$numValues++;
				}
				
				$numItems++;
			}			  
			
			
			if (isset($_POST['buying'])){
				
				$APIRequestURL.="&itemFilter(".$numItems.").name=ListingType";
				$numValues=0;
				if(in_array("FixedPrice" , $_POST['buying'])){
					$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=FixedPrice";
					$numValues++;
				}
				if(in_array("Auction" , $_POST['buying'])){
					$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=Auction";
					$numValues++;
				}
				if(in_array("Classified" , $_POST['buying'])){
					$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=Classified";
					$numValues++;
				}
				
				$numItems++;
			}  
							  
			if (isset($_POST['returnsAcceptedOnly'])){
				$APIRequestURL.="&itemFilter(".$numItems.").name=ReturnsAcceptedOnly"."&itemFilter(".$numItems.").value=true";
				$numItems++;
			}
							  
			if (isset($_POST['shippingFree'])){
				$APIRequestURL.="&itemFilter(".$numItems.").name=FreeShippingOnly"."&itemFilter(".$numItems.").value=true";
				$numItems++;
			}
							  
			if (isset($_POST['shippingExpedited'])){
				$APIRequestURL.="&itemFilter(".$numItems.").name=ExpeditedShippingType"."&itemFilter(".$numItems.").value=Expedited";
				$numItems++;
			}
			
			if(isset($_POST['days']) && $_POST['days']!=""){
				$APIRequestURL.="&itemFilter(".$numItems.").name=MaxHandlingTime"."&itemFilter(".$numItems.").value=".$_POST['days'];
				$numItems++;
			}
			
			if (isset($_POST['sort'])){
				$APIRequestURL.="&sortOrder=".$_POST['sort'];
			}
			
			if (isset($_POST['result'])){
				$APIRequestURL.="&paginationInput.entriesPerPage=".$_POST['result'];
			}
						  
		
			$responseXML = simplexml_load_file($APIRequestURL);
			if($responseXML->ack == "Success"){
				if($responseXML->paginationOutput->totalEntries > 0){
					$result.="<div id='output_outer'>";
					$result.="<div id='output_header'><h3>".$responseXML->paginationOutput->totalEntries." Results for <i>".$_POST['keywords']."</i></h3></div><br />";
					
				foreach($responseXML->searchResult->item as $item) {
					$result.="<div id='output_inner'><table id='resultTable' border='0' width='640'><tr><td rowspan='10'><img src='".$item->galleryURL."' width='220px' height='220px' /></td><br />";
					$result.="<td><a href='".$item->viewItemURL."'>".$item->title."</a></td></tr><br />";
					$result.="<tr><td><div  id='condi'><b>Condition:</b>";
					
					$conditionID = $item->condition->conditionId;
					if($conditionID == "1000"){
						$result.=" New ";
					}
					elseif($conditionID == "3000"){
						$result.=" Used ";
					}
					elseif($conditionID == "4000"){
						$result.=" Very Good ";
					}
					elseif($conditionID == "5000"){
						$result.=" Good ";
					}
					elseif($conditionID == "6000"){
						$result.=" Acceptable ";
					}
					elseif($item->condition->conditionDisplayName == ""){
					$result.=" Not Available ";
					}
					else{
						$result.=" ".$item->condition->conditionDisplayName."  ";
					}
					$result.="</div>";
					
					if($item->topRatedListing == "true"){
						if($item->condition->conditionDisplayName == "New" || $conditionID == "3000" || $conditionID == "5000" || $conditionID == "6000")
							$result.="  <img id='rating1' src='http://cs-server.usc.edu:45678/hw/hw6/itemTopRated.jpg' width='80px' height='60px' >";
						else if($conditionID == "4000")
							$result.="  <img id='rating2' src='http://cs-server.usc.edu:45678/hw/hw6/itemTopRated.jpg' width='80px' height='60px' >";
						else
							$result.="  <img id='rating3' src='http://cs-server.usc.edu:45678/hw/hw6/itemTopRated.jpg' width='80px' height='60px' >";
					}
						
					
					$result.="<br /></td></tr><tr><td>";
					
					if($item->listingInfo->listingType == "FixedPrice" || $item->listingInfo->listingType == "StoreInventory")
						$result.="<b>Buy It Now</b>";
					elseif($item->listingInfo->listingType == "Auction")
						$result.="<b>Auction</b>";
					elseif($item->listingInfo->listingType == "Classified")
						$result.="<b>Classified Ad</b>";
					else
						$result.="<b>".$item->listingInfo->listingType."</b>";
					
					$result.="<br /></td></tr><tr><td>";
					
					if($item->returnsAccepted == "true")
						$result.="Seller Accepts return";
					
					$result.="<br />";
					
					if($item->shippingInfo->shippingServiceCost && floatval($item->shippingInfo->shippingServiceCost) == 0.0)
						$result.="FREE Shipping -- ";
					else
						$result.="Shipping Not Free -- ";
					
					
					if($item->shippingInfo->expeditedShipping == "true")
						$result.="Expedited Shipping Available --";
					
					if($item->shippingInfo->handlingTime != "")
						$result.="  Handled for shipping in ".$item->shippingInfo->handlingTime." day(s)";
					
					$result.="<br /></td></tr><tr><td>";
					
					if($item->shippingInfo->shippingServiceCost && floatval($item->shippingInfo->shippingServiceCost) > 0.0)
						$result.="<b>Price: $".$item->sellingStatus-> convertedCurrentPrice." (+ $".$item->shippingInfo->shippingServiceCost." for shipping)</b>  ";
					else
						$result.="<b>Price: $".$item->sellingStatus-> convertedCurrentPrice." </b>  ";
					$result.="<i>   From ".$item->location."</i><br /></td></tr></table></div>";
					}
					$result.="</div>";
				}
				else 
					$result.="<div id='no_output' margin-top:-15px'><div id='output_header'><h2>No results found</h2></div></div>";
			
			}
		?>
		
		
		<script language="Javascript" >
			function clearForm(){
				var elements = document.getElementById("myform").elements;
				for(i=0; i<elements.length; i++) {
					field_type = elements[i].type.toLowerCase();
					switch(field_type) {
 
					        case "text":elements[i].value = "";
										break;
					    case "checkbox":if (elements[i].checked) {
											elements[i].checked = false;
										}
								break;
					case "select-one":elements[i].selectedIndex = 0;
										break;
							   default :break;
					}
				}
				if(document.getElementById("output_outer")){
					document.getElementById("output_outer").innerHTML="";
					document.getElementById("output_outer").style.borderColor="white";
				}
				else if(document.getElementById("no_output")){
					document.getElementById("no_output").innerHTML="";
					document.getElementById("no_output").style.borderColor="white";
				}
			}
			
			str="";
			function query(){
				if(Keywords.value=="")
					str+="  Please enter value for Key Words!! ";
				if((From.value!=null && parseFloat(From.value,10) < 0) || (To.value!=null && parseFloat(To.value,10) < 0))
					str+="  Price must be a positive or a decimal number!! ";
				if(From.value!=null && To.value!=null && parseFloat(From.value,10) > parseFloat(To.value,10))
					str+="  Minimum price must be lower than or same as the Maximum price!! ";
				if(Days.value!=null && parseInt(Days.value,10) < 1)
					str+="  Handling Time will take atleast 1 day!! ";
				if(str!="")
					alert(str);
			}
				
		</script>
		<?php echo $result ?>
		<noscript>
	</body>
</html>