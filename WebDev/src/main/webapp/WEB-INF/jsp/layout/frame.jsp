<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
  <head>
    <title></title>
  </head>
  <body>
        <table>
      <tr>
        <td colspan="2">
          <tiles:insertAttribute name="header" />
        </td>
      </tr>
      <tr>
        <td>
          <tiles:insertAttribute name="side" />
        </td>
        <td>
          <tiles:insertAttribute name="body" />
        </td>
      </tr>
    </table>
  </body>
</html>