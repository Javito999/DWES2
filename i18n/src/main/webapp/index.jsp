<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<c:if test="${param.idioma!=null}">
<fmt:setLocale value="${param.idioma}" scope="session"/>
</c:if>
<fmt:setBundle basename="traduccion" />
<!DOCTYPE html>
<html>
<head>
<title>JSP/JSTL i18n</title>
</head>
<body>
<p>
<fmt:message key="saludo" />
</p>
<a href="./index.jsp?idioma=en">ingles</a>
<a href="./index.jsp?idioma=es">español</a>
<a href="./index.jsp?idioma=fr">frances</a>
</body>
</html>


