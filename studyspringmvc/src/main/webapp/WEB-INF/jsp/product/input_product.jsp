<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>


<body>

    <div class="container">
        <div class="panel panel-default">
        	
        	<div class="panel-heading text-center">
        	<h2>Hello World! I'm index.jsp</h2>
        	</div>
        
	        <div class="panel-body">
            <s:url value="/product/create" var="saveNewProductURL" />
            <!--  
			<form:form id="form" method="post" modelAttribute="productForm" cssClass="form-horizontal" action="${saveNewProductURL}">
			-->
			<div>
					<c:forEach var="error" items="${errors}">
					<b><s:message message="${error}"/></b>${error.field}|${error.code}|${error.defaultMessage}|${error.objectName}
					<br />
					</c:forEach>
			</div>
			<form id="productForm" name="productForm" method="post" action="<c:url value="/product/create"/>">
				<fieldset>
					<div id="legend" class="">
						<legend class="">商品输入</legend>
					</div>
		
					<div class="control-group">
		
						<!-- Text input-->
						<label class="control-label" for="input01">商品名</label>
						<div class="controls">
						<%--  
							<form:input path="productName" cssClass="input-xlarge"/>
					    --%>
							<input type="text" placeholder="" class="input-xlarge" name="productName" value="${product.productName}">
							<p class="help-block">请输入商品名</p>
							<form:errors path="productName" cssClass="error" />
							<%--
							<form:errors path="productName" cssClass="error" />
							--%>
						</div>
					</div>
					<div class="control-group">
		
						<!-- Textarea -->
						<label class="control-label">商品介绍</label>
						<div class="controls">
							<div class="textarea">
								<textarea type="" class="" name="introduce"> ${product.introduce} </textarea>
							</div>
						</div>
					</div>
					<div class="control-group">
		
						<!-- Appended input-->
						<label class="control-label">价格</label>
						<div class="controls">
							<div class="input-append">
								<input class="span2" placeholder="" type="text" name="price" value="${product.price}"> 
								<span class="add-on">元</span>
							</div>
							<p class="help-block">请输入价格，比如10.00</p>
						</div>
		
					</div>
		
					<div class="control-group">
						<label class="control-label">商品图像</label>
		
						<!-- File Upload -->
						<div class="controls">
							<input class="input-file" id="fileInput" type="file">
						</div>
					</div>
		
					<div class="control-group">
						<label class="control-label"></label>
		
						<!-- Button -->
						<div class="controls">
							<button class="btn btn-primary">保存</button>
						</div>
					</div>
		
				</fieldset>
				</form> 
			<!--</form:form>-->
			</div>
		</div>
	</div>

</body>
</html>
