<@layout.mainLayout
styles=[]
jscripts=[]>

<section class="products">
    <ul>
        <#list products.products as product>
            <li>
                <a href="${product.url}">${product.name}</a>
            </li>
        </#list>
    </ul>
</section>


</@layout.mainLayout>
