<#macro mailForm imageShare>
    <div class="mailForm">
        <#assign emailShareForm = imageShare.emailShareForm >

        <input type="hidden" id="imageUrl" name="imageUrl" value="${emailShareForm.imageUrl}" />

        <div class="formItem">* required fields</div>
        <div class="formItem">
            <label for="senderName">Your Name</label>
            <input type="text" value="${emailShareForm.senderName}" class="textInput" name="senderName" id="senderName">
        </div>
        <div class="formItem ${imageShare.replyToError}">
            <label for="replyTo">*Your Email</label>
            <input type="text" value="${emailShareForm.replyTo}" class="textInput" name="replyTo" id="replyTo"/>
            <div class="errorMessage"><strong>${imageShare.replyToErrorMessage}</strong></div>
        </div>
        <div class="formItem ${imageShare.toError}">
            <label for="to">*Recipient's Email</label>
            <input type="text" value="${emailShareForm.to}" class="textInput" name="to" id="to"/>
            <div class="errorMessage"><strong>${imageShare.toErrorMessage}</strong></div>
        </div>
        <div class="formItem">
            <label for="subject">Subject Line</label>
            <input type="text" value="${emailShareForm.subject}" class="textInput" name="subject" id="subject"/>
        </div>
        <div class="formItem">
            <label for="message">Message</label>
            <span class="messageIndicator">(a link to the page will be included in the message)</span>
            <textarea class="textInput emailMessage" name="message" id="message">${emailShareForm.message}</textarea>
            <div id="messageCounter" class="counter"></div>
        </div>
        <input class="send-share" type="button" value="Send"/>
    </div>
</#macro>