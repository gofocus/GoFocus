
<#include "/ftl/addItem.ftl" />
<#include "/ftl/editItem.ftl"/>
<#include "/ftl/login.ftl"/>
<#include "/ftl/register.ftl"/>

<@addItem/>
<@editItem/>
<@login/>
<@register/>

<#macro header_test>
<header class="header-pos">
    <div class="header-area header-middle">
        <div class="container-fluid">
            <!--滚动页首菜单栏-->
            <div class="col-md-10 col-sm-9 col-xs-12 text-right xs-center">

                <!--滚动菜单栏-->
                <div class="main-menu display-inline hidden-sm hidden-xs">
                    <nav>
                        <ul>
                            <#--<label>欢迎,<@shiro.principal property="username"/></label>-->
                            <#--<@shiro.guest>-->
                                <li><a href="#" onclick="login()">登录</a></li>
                                <li><a href="#" onclick="register()">注册</a></li>
                                <#--<li><a href="/user/login">登录</a></li>-->
                                <#--<li><a href="/user/register">注册</a></li>-->
                            <#--</@shiro.guest>-->
                            <@shiro.user>
                                <li><a href="/user/logout">注销</a></li>
                            </@shiro.user>
                            <li><a href="/">Home</a></li>
                            <@shiro.hasPermission name="item:create">
                                <#--<li><a href="/items/addItems">添加商品</a></li>-->
                            <li><a href="#" onclick="addItem()">添加商品</a></li>
                            </@shiro.hasPermission>
                            <@shiro.hasPermission name="item:update">
                                <li><a href="/items/editAllItems">批量管理商品</a></li>
                            </@shiro.hasPermission>
                        </ul>
                    </nav>
                </div>

                <!--顶部搜索栏-->
                <div class="search-block-top display-inline">
                    <div class="icon-search">搜索</div>
                    <div class="toogle-content">
                        <form action="/items/query_items" id="searchbox" method="post">
                            <input type="text" name="itemsCustom.name" placeholder="Search"/>
                            <button class="button-search"></button>
                        </form>
                    </div>
                </div>

                <!--微型购物车-->
                <div class="shopping-cart ml-20 display-inline">
                    <a href="/cart/" target="_blank" >
                        <b id="microCart">购物车</b>
                    </a>
                    <ul id="microCart2">
                        <#--<li>
                            <div class="cart-img">
                                <a href="#"><img src="../img/cart/1.jpg" alt=""/></a>
                            </div>
                            <div class="cart-content">
                                <h3><a href="#"> 1 X Faded...</a></h3>
                                <span><b>S, Orange</b></span>
                                <span class="cart-price">£ 16.84</span>
                            </div>
                            <div class="cart-del">
                                <i class="fa fa-times-circle"></i>
                            </div>
                        </li>
                        <li>
                            <div class="cart-img">
                                <a href="#"><img src="../img/cart/1.jpg" alt=""/></a>
                            </div>
                            <div class="cart-content">
                                <h3><a href="#"> 1 X Faded...</a></h3>
                                <span><b>S, Orange</b></span>
                                <span class="cart-price">£ 16.84</span>
                            </div>
                            <div class="cart-del">
                                <i class="fa fa-times-circle"></i>
                            </div>
                        </li>
                        <li>
                            <div class="shipping">
                                <span class="f-left">Shipping </span>
                                <span class="f-right cart-price"> $7.00</span>
                            </div>
                            <hr class="shipping-border"/>
                            <div class="shipping">
                                <span class="f-left"> Total </span>
                                <span class="f-right cart-price">$692.00</span>
                            </div>
                        </li>
                        <li class="checkout m-0"><a href="#">checkout <i class="fa fa-angle-right"></i></a></li>-->
                    </ul>
                </div>

                <!--微型下拉菜单栏-->
                <div class="setting-menu display-inline">
                    <div class="icon-nav current"></div>
                    <ul class="content-nav toogle-content">
                        <li class="currencies-block-top">
                            <div class="current"></div>
                            <ul>
                                <@shiro.user>
                                    <b><a href="/user/user_detail/${activeUser.userid}">我的账户</a></b>
                                    <li><a href="/user/modify_password">修改密码</a></li>
                                    <li><a href="/user/logout">注销</a></li>
                                </@shiro.user>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</header>

</#macro>
