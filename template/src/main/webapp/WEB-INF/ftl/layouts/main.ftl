<#macro mainLayout
styles = []
jscripts = []>

<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <link rel="SHORTCUT ICON" href="${webRoot}favicon.ico"/>
    <link rel="stylesheet" href="${webRoot}css/reset.css"/>
    <#list styles as css>
        <link rel="stylesheet" type="text/css" href="${webRoot}${css}"/>
    </#list>
    <script src="${webRoot}js/jquery-1.6.2.js"></script>
</head>

<body>
<div class="body-wrapper">
    <div class="grid-container">
        <#include "header.ftl"/>
        <section class="body-content">
            <#nested/>
        </section>
        <#include "footer.ftl"/>
    </div>
    <#list jscripts as script>
        <script src="${webRoot}${script}"></script>
    </#list>
</div>
</body>
</html>
</#macro>