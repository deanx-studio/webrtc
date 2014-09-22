<%@ page language="java" contentType="application/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//String context = request.getContextPath();
	request.setAttribute("context", "http://www.guantravel.com");
%>
<?xml version="1.0" encoding="UTF-8"?>
<sitemapindex xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
<c:forEach var="items" items="${artileList}" varStatus="status">
<sitemap><loc>${context }/custom/detail?id=${items.id}</loc><lastmod>${fn:substring(items.specialMaketime,0,10)}T12:29:16-05:00</lastmod></sitemap>
</c:forEach>
<sitemap><loc>${context }/custom/book</loc><lastmod>2014-09-11T12:29:16-05:00</lastmod></sitemap>
<sitemap><loc>${context }/custom/private</loc><lastmod>2014-09-11T12:29:16-05:00</lastmod></sitemap>
<sitemap><loc>${context }/custom/group/list</loc><lastmod>2014-09-11T12:29:16-05:00</lastmod></sitemap>
<sitemap><loc>${context }/custom/home</loc><lastmod>2014-09-11T12:29:16-05:00</lastmod></sitemap>
<sitemap><loc>${context }/custom/articles</loc><lastmod>2014-09-12T12:29:16-05:00</lastmod></sitemap> 
</sitemapindex>