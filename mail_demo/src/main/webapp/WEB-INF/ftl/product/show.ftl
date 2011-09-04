<#import "../mail/share_load.ftl" as shareLoad>

<@layout.mainLayout
styles=[]
jscripts=[]>

<section class="product">

${product.name}
    This product url is ${product.url}

<@shareLoad.shareLink product.id/>
<@shareLoad.shareMedia />
</section>


</@layout.mainLayout>
