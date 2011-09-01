<#import "./components/get_start.ftl" as getStart>

<@layout.mainLayout
styles=["css/homepage.css"]
jscripts=["js/homepage.js"]>

<section class="getting-started">
    <div class="panel-content">
    <@getStart.getStart message />
    </div>
</section>

<section class="message">
    <ul>
        <#list products as product>
            <li>${product}</li>
        </#list>
    </ul>
</section>

</@layout.mainLayout>
