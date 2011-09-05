<#import "../mail/share_load.ftl" as shareLoad>

<@layout.mainLayout
styles=[]
jscripts=[]>

<section class="product">

<form name="input" action="" method="post">
Product Id: <input type="text" name="productId" value="${product.id}"/>
Product Name: <input type="text" name="productName" value="${product.name}"/>
<input type="submit" value="Submit" />
</form>

<a href="/home/product/">index</a>

</section>


</@layout.mainLayout>
