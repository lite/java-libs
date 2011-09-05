<#import "../mail/share_load.ftl" as shareLoad>

<@layout.mainLayout
styles=[]
jscripts=[]>

<section class="product">

${product.id}
${product.name}
This product url is ${product.url}

<a href="${product.id}/edit">edit</a>
<a href="${product.id}/delete">delete</a>
<a href="/home/product">index</a>

<@shareLoad.shareLink product.id/>
<@shareLoad.shareMedia />
</section>


</@layout.mainLayout>
