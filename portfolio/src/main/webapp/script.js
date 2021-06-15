// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}



async function displayJson(){
    const responseServer = await fetch("/hello")
    const responseJson = await responseServer.json()
    console.log(responseJson)
    const listElements = document.getElementById("jsonContainer")
    listElements.innerHTML = ""

    randomMessage = responseJson[getRandomInt(2)]
    listElements.appendChild(
        createListElement(randomMessage)
    )


}

function createListElement(obj){
    let message = ""
    for(key in obj){
        message = obj[key]
    }

    const ele = document.createElement("li")
    ele.innerText = message
    return ele
}
function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}

function displayContactMe(){
    fetch("/list-contactMe").then(res => res.json()).then(contactMes => {
        console.log(contactMes)
        const contactMeElement = document.getElementById("contactMe-list")
        contactMes.map(contactMe => {
            contactMeElement.appendChild(createContactMeElement(contactMe))
        })
    })
}

function createContactMeElement(contactMe){
    const ele = document.createElement("li");
    ele.className = "contactMe";

    const titleEle = document.createElement("span");
    titleEle.innerText = contactMe.title;

   const firstName = document.createElement("p");
   const lastName = document.createElement("p");
   const subject = document.createElement("p");
   
   firstName.innerText = contactMe.firstName;
   lastName.innerText = contactMe.lastName;
   subject.innerText = contactMe.subject;
   titleEle.appendChild(firstName);
   titleEle.appendChild(lastName);
   titleEle.appendChild(subject);

   return ele;


    

}
