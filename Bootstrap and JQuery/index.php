<?php
	header('Access-Control-Allow-Origin: *');
	header('Access-Control-Allow-Methods: GET, POST');
	$host = "http://svcs.ebay.com/services/search/FindingService/v1?";  
	$responseDataFormat = "XML";   
	$version = "1.0.0";
	$appID   = <your-appID>
	$result = "";
	$numItems=0;
	$numValues=0;
	$numSelector=0;
	
	$APIRequestURL  =  $host
					  ."siteid=0"
					  ."&SECURITY-APPNAME=".$appID
					  ."&OPERATION-NAME=findItemsAdvanced"
					  ."&SERVICE-VERSION=".$version
					  ."&RESPONSE-DATA-FORMAT=".$responseDataFormat;
	
	if(isset($_GET['keywords'])){		
		$APIRequestURL.="&keywords=".urlencode($_GET['keywords']);
	}
	
	if(isset($_GET['from']) && $_GET['from']!="nil"){
		$APIRequestURL.="&itemFilter(".$numItems.").name=MinPrice"."&itemFilter(".$numItems.").value=".$_GET['from'];
		$numItems++;
	}
	if(isset($_GET['to']) && $_GET['to']!="nil"){
		$APIRequestURL.="&itemFilter(".$numItems.").name=MaxPrice"."&itemFilter(".$numItems.").value=".$_GET['to'];
		$numItems++;
	}
	
	
	if ((isset($_GET['condition1']) && $_GET['condition1']!="nil" )|| (isset($_GET['condition2']) && $_GET['condition2']!="nil") || (isset($_GET['condition3']) && $_GET['condition3']!="nil") || (isset($_GET['condition4']) && $_GET['condition4']!="nil") || (isset($_GET['condition5']) &&  $_GET['condition5']!="nil")){
		
		$APIRequestURL.="&itemFilter(".$numItems.").name=Condition";
	
		if (isset($_GET['condition1']) && $_GET['condition1'] == "1000"){
			$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=1000";
			$numValues++;
		}
		if (isset($_GET['condition2']) && $_GET['condition2'] == "3000"){
			$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=3000";
			$numValues++;
		}
		if (isset($_GET['condition3']) && $_GET['condition3'] == "4000"){
			$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=4000";
			$numValues++;
		}
		if (isset($_GET['condition4']) && $_GET['condition4'] == "5000"){
			$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=5000";
			$numValues++;
		}
		if (isset($_GET['condition5']) && $_GET['condition5'] == "6000"){
			$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=6000";
			$numValues++;
		}
		$numItems++;
	}			  
	
	
	if ((isset($_GET['buy1']) && $_GET['buy1']!="nil") || (isset($_GET['buy2']) && $_GET['buy2']!="nil") || (isset($_GET['buy3']) && $_GET['buy3']!="nil")){
		
		$APIRequestURL.="&itemFilter(".$numItems.").name=ListingType";
		$numValues=0;
		if(isset($_GET['buy1']) && $_GET['buy1'] == "FixedPrice"){
			$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=FixedPrice";
			$numValues++;
		}
		if(isset($_GET['buy2']) && $_GET['buy2'] == "Auction"){
			$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=Auction";
			$numValues++;
		}
		if(isset($_GET['buy3']) && $_GET['buy3'] == "Classified"){
			$APIRequestURL.="&itemFilter(".$numItems.").value(".$numValues.")=Classified";
			$numValues++;
		}
		$numItems++;
	} 
					  
	if (isset($_GET['returnsAcceptedOnly']) && $_GET['returnsAcceptedOnly']!="nil"){
		$APIRequestURL.="&itemFilter(".$numItems.").name=ReturnsAcceptedOnly"."&itemFilter(".$numItems.").value=true";
		$numItems++;
	}
					  
	if (isset($_GET['shippingFree']) && $_GET['shippingFree']!="nil" ){
		$APIRequestURL.="&itemFilter(".$numItems.").name=FreeShippingOnly"."&itemFilter(".$numItems.").value=true";
		$numItems++;
	}
					  
	if (isset($_GET['shippingExpedited']) && $_GET['shippingExpedited']!="nil"){
		$APIRequestURL.="&itemFilter(".$numItems.").name=ExpeditedShippingType"."&itemFilter(".$numItems.").value=Expedited";
		$numItems++;
	}
	
	if(isset($_GET['days']) && $_GET['days']!="nil"){
		$APIRequestURL.="&itemFilter(".$numItems.").name=MaxHandlingTime"."&itemFilter(".$numItems.").value=".$_GET['days'];
		$numItems++;
	}
	
	if (isset($_GET['sort'])){
		$APIRequestURL.="&sortOrder=".$_GET['sort'];
	}
	
	if (isset($_GET['result'])){
		$APIRequestURL.="&paginationInput.entriesPerPage=".$_GET['result'];
	}
	$APIRequestURL.="&paginationInput.pageNumber=".$_GET['pageNum'];
	$APIRequestURL.="&outputSelector[".$numSelector."]=SellerInfo";
	$numSelector++;
	$APIRequestURL.="&outputSelector[".$numSelector."]=PictureURLSuperSize";
	$numSelector++;
	$APIRequestURL.="&outputSelector[".$numSelector."]=StoreInfo";
	$numSelector++;
	$APIRequestURL.="&outputSelector[".$numSelector."]=ShippingInfo";
	$numSelector++;
	
	$responseXML = simplexml_load_file($APIRequestURL);
	
	$json = array();
	$index = 0;

		if($responseXML->paginationOutput->totalEntries > 0){
			$json['ack'] = "Success";
			$json['resultCount'] = intval($responseXML->paginationOutput->totalEntries);
			$json['pageNumber'] = intval($responseXML->paginationOutput->pageNumber);  
			$json['itemCount'] = intval($responseXML->paginationOutput->entriesPerPage); 

		foreach($responseXML->searchResult->item as $item) {
			$item_json = array();
			$item_basic = array();
			$item_sell = array();
			$item_ship = array();
			
			
			if ($item->galleryURL) {
				$item_basic['galleryURL'] = (string)$item->galleryURL;
			}
			$item_basic['viewItemURL']  = (string)$item->viewItemURL;
			$item_basic['title'] = (string)$item->title;
			$item_basic['pictureURLSuperSize'] = (string)$item->pictureURLSuperSize;
			
			 
			$conditionID = $item->condition->conditionId;
			if($conditionID == "1000")
				$item_basic['conditionDisplayName'] = "New";
			elseif($conditionID == "3000")
				$item_basic['conditionDisplayName'] = "Used";
			elseif($conditionID == "4000")
				$item_basic['conditionDisplayName'] = "Very Good";
			elseif($conditionID == "5000")
				$item_basic['conditionDisplayName'] = "Good";
			elseif($conditionID == "6000")
				$item_basic['conditionDisplayName'] = "Acceptable";
			elseif($item->condition->conditionDisplayName == "")
				$item_basic['conditionDisplayName'] = "Condition: N/A";
			else
				$item_basic['conditionDisplayName'] = (string)$item->condition->conditionDisplayName;
			
			if ($item->topRatedListing && $item->topRatedListing == "true") {
				$item_basic['topRatedListing'] = "true";
			}
			else 
				$item_basic['topRatedListing'] = "false";
				
			if($item->listingInfo->listingType == "FixedPrice" || $item->listingInfo->listingType == "StoreInventory")
				$item_basic['listingType'] = "Buy It Now";
			elseif($item->listingInfo->listingType == "Auction")
				$item_basic['listingType'] = "Auction";
			elseif($item->listingInfo->listingType == "Classified")
				$item_basic['listingType'] = "Classified Ad";
			else if($item->listingInfo->listingType)
				$item_basic['listingType'] = "N/A";
			else 
				$item_basic['listingType'] = "Listing Type: N/A";
			
			
			if ($item->returnsAccepted == "true")
				$item_ship['returnsAccepted'] = "true";
			else 
				$item_ship['returnsAccepted'] = "false";
								
			if ($item->shippingInfo) {
					
				
				if ($item->shippingInfo->expeditedShipping) 
					$item_ship['expeditedShipping'] = "true";
				else 
					$item_ship['expeditedShipping'] = "false";
				
				$item_ship['handlingTime'] = intval($item->shippingInfo->handlingTime);
				$item_basic['shippingServiceCost'] = floatval($item->shippingInfo->shippingServiceCost);
			}
			else {
				
				$item_ship['expeditedShipping'] = "Expedited Shipping Details: N/A";
				$item_ship['handlingTime'] = "Handling Time: N/A";
				$item_basic['shippingServiceCost'] = 0.0;
			}
			  
			if ($item->sellingStatus)
				$item_basic['convertedCurrentPrice'] = floatval($item->sellingStatus->convertedCurrentPrice);
			
			$item_ship['shippingType'] = (string)$item->shippingInfo->shippingType;
			if(count((array)$item->shippingInfo->shipToLocations) == 1)
				$item_ship['shipToLocations'] = (string)$item->shippingInfo->shipToLocations;
			else
				$item_ship['shipToLocations'] = (array)$item->shippingInfo->shipToLocations;
			
			$item_ship['oneDayShippingAvailable'] = (string)$item->shippingInfo->oneDayShippingAvailable;
			
			$item_basic['location'] = (string)$item->location;
			$item_basic['categoryName'] = (string)$item->primaryCategory->categoryName;
			
			$item_sell['sellerUserName'] = (string)$item->sellerInfo->sellerUserName;
			$item_sell['feedbackScore'] = (string)$item->sellerInfo->feedbackScore;
			$item_sell['positiveFeedbackPercent'] = (string)$item->sellerInfo->positiveFeedbackPercent;
			$item_sell['feedbackRatingStar'] = (string)$item->sellerInfo->feedbackRatingStar;
			$item_sell['topRatedSeller'] = (string)$item->sellerInfo->topRatedSeller;
			$item_sell['sellerStoreName'] = (string)$item->storeInfo->storeName;
			$item_sell['sellerStoreURL'] = (string)$item->storeInfo->storeURL;
			
			$item_json['basicInfo'] = $item_basic;
			$item_json['sellerInfo'] = $item_sell;
			$item_json['shippingInfo'] = $item_ship;
			$json['item' . $index] = $item_json;
			$index = $index + 1;
			
		  }
		}
		else if($responseXML->paginationOutput->totalEntries == 0)
			$json['ack'] = "No results found";
		
		echo json_encode($json);
?>
		