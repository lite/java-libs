<@layout.mainLayout
styles=[]
jscripts=[]>

<section class="products">
    <ul>
        <#list products.products as product>
            <li>${product.product_name}
                <a href="/home/product/${product.product_id}">show</a>
                <a href="/home/product/${product.product_id}/edit">edit</a>
                <a href="/home/product/${product.product_id}/delete">delete</a>
            </li>
        </#list>
    </ul>

    <a href="/home/product/new">new</a>
    <a href="/home/product/delete">delete all</a>

</section>


</@layout.mainLayout>
