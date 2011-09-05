<#macro shareLink product_id>
<a class="share-link" href="#" ajaxUrl="${webRoot}mail-share-${product_id}">Share with email</a>
</#macro>

<#macro shareMedia>
<script src="${webRoot}js/jquery-ui-1.8.13.custom.min.js"></script>
<script src="${webRoot}js/mail_share.js"></script>
<link rel="stylesheet" href="${webRoot}css/jquery-ui-1.8.13.custom.css" type="text/css" media="all"/>
<link rel="stylesheet" href="${webRoot}css/mail_share.css" type="text/css" media="all"/>
</#macro>
