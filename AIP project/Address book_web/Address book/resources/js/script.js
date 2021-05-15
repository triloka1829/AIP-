let onloadFlag = false;
window.onload = function() {
  getData();
  resetFields();
}

function resetFields(){
  document.getElementById("name").value = "";
  document.getElementById("phone").value = "";
  document.getElementById("company").value = "";
  document.getElementById("updateName").value = "";
  document.getElementById("updatePhone").value = "";
  document.getElementById("updateCompany").value = "";
  document.getElementById("updateId").value = "";
}

function fillData(data){
  console.log(onloadFlag);
  let dataList = JSON.parse(data);
  for (let index = 0; index < dataList.length; index++) {
    const eachCard = dataList[index];
    let newEmptyElement = `<div class="col-md-3 addressCard" id="addressCard">
    <div class="card home-card-styling">
      <div class="row">
        <div class="col-md-2">
          <div class="card-prof-pic">
            <i class="fa fa-user-circle fa-2x" aria-hidden="true"></i>
          </div>
        </div>
        <div class="col-md-7">
          <div class="card-body">
            <h4 class="card-title">`+dataList[index].personName+`</h4>
            <p class="card-text">`+dataList[index].personPhone+`</p>
          </div>
        </div>
        <div class="col-md-3">
          <button type="button" onclick="deleteAddress(`+dataList[index].personId+`, getData)" class="btn fa fa-trash"></button>
          <button type="button" onclick="updateAddressUI('`+dataList[index].personId+`', '`+dataList[index].personName+`', '`+dataList[index].personPhone+`', '`+dataList[index].personCompany+`')" class="btn fa fa-edit"></button>
        </div>
        
      </div>
    </div>
  </div>`;
  if(document.getElementsByClassName("addressCard").length <= index){
    $("#cardsStack").append($.parseHTML(newEmptyElement));
  }
}
  console.log(document.getElementsByClassName("addressCard").length)+1;
  
}

function addNewCard(){
    /* appending a address card HTML element to the existing element */
    // console.log(document.getElementById('cardsStack').getElementsByClassName('addressCard')[0].append(sampleEmptyCard));
    let cardsStack = $("#cardsStack");
    let addressCards = cardsStack.find('div.addressCard');
    console.log(addressCards.length+" length");
    let lastCard = addressCards[addressCards.length-1];
    if(addressCards.length === 0){
        cardsStack.append(emptyCard());
    }else{
        let newEmptyCard = emptyCard(--addressCards.length);
        $("#cardsStack").append($.parseHTML(newEmptyCard));
    }
    
}

function emptyCard(Id){
    console.log(Id+1);
    Id++;
    let newEmptyElement = `<div class="col-md-3 addressCard" id="addressCard"`+Id+`>
    <div class="card home-card-styling">
      <div class="row">
        <div class="col-md-3">
          <div class="card-prof-pic">
            <i class="fa fa-user-circle fa-4x" aria-hidden="true"></i>
          </div>
        </div>
        <div class="col-md-7">
          <div class="card-body">
            <h4 class="card-title">Name</h4>
            <p class="card-text">phone</p>
          </div>
        </div>
        <div class="col-md-2">
          <button type="button" class="btn btn-primary">trash</button>
        </div>
      </div>
    </div>
  </div>`;
  console.log();
  return newEmptyElement;
}

function newAddress(){
  let name,phone,address;
  name = document.getElementById("name").value;
  phone = document.getElementById("phone").value;
  company = document.getElementById("company").value;
  console.log(name+" "+phone+" "+company);
  postData(name, phone, company);
  resetFields();
}

function postData(name, phone, company){
  let ENDPOINT_URL = "http://localhost:8080/addAddress";
  $.ajax({
    type: "POST",
    url: ENDPOINT_URL + "?name=" + name + " &phone=" + phone+ "&company="+ company,
    dataType: 'json',
    success: function(result){
        console.log(result);
    
    },  statusCode: {
      200: function() {
        location.reload();
      }
    }
  });
}

function updateData(){
  let name,phone,address;
  name = document.getElementById("updateName").value;
  phone = document.getElementById("updatePhone").value;
  company = document.getElementById("updateCompany").value;
  id = document.getElementById("updateId").value;
  let ENDPOINT_URL = "http://localhost:8080/updateAddress";
  $.ajax({
    type: "POST",
    url: ENDPOINT_URL + "?name=" + name + " &phone=" + phone+ "&company="+ company+"&id="+id,
    dataType: 'json',
    success: function(result){
        console.log(result);
    
    },  statusCode: {
      200: function() {
        location.reload();
      }
    }
  });0
  resetFields();
}



function getData(){
  console.log('Fetching Data');
  let ENDPOINT_URL = "http://localhost:8080/findAllAddress";
  $.ajax({
    type: "GET",
    url: ENDPOINT_URL,
    success: function(data){
      console.log(data);
      fillData(data);
    }
  });
}

function deleteAddress(id){
  let ENDPOINT_URL = "http://localhost:8080/deleteAddress";
  $.ajax({
    type: "POST",
    url: ENDPOINT_URL + "?id=" + id,
    dataType: 'json',
    success: function(result){
        console.log(result); 
        location.reload();
    },  statusCode: {
      200: function() {
        location.reload();
      }
    }
  });
  
}

function updateAddressUI(id, name, phone, company){
  document.getElementById("updateName").value = name;
  document.getElementById("updatePhone").value = phone;
  document.getElementById("updateId").value = id;
  document.getElementById("updateCompany").value = company;
  $("#updateModal").modal("toggle");
}
