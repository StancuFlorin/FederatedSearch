<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<h3 class="page-header">Search results for: ${query}</h3>

<table class="table table-hover">
    <thead>
        <tr>
            <td>Title</td>
            <td>Year</td>
            <td>Country</td>
            <td>Rating</td>
            <td>External Links</td>
        </tr>
    </thead>
    <tbody>
    <c:set var="contor" value="${0}" />
    <c:forEach var="movie" items="${movies}">

        <!-- Modal -->
        <div class="modal fade" id="movieModal${contor}" tabindex="-1" role="dialog" aria-labelledby="movieModalLabel${contor}" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="movieModal${contor}">${movie.title}</h4>
                    </div>
                    <div class="modal-body" style="min-height: 300px;">
                        <img src="${movie.poster}" height="250" style="float: right; padding: 5px;"/>
                        <c:if test="${not empty movie.year}">
                            <i>Year:</i> ${movie.year}<br/>
                        </c:if>
                        <c:if test="${not empty movie.country}">
                            <i>Country:</i> ${movie.country}<br/>
                        </c:if>
                        <c:if test="${not empty movie.genre}">
                            <i>Genre:</i> ${movie.genre}<br/>
                        </c:if>
                        <c:if test="${not empty movie.language}">
                            <i>Language:</i> ${movie.language}<br/>
                        </c:if>
                        <c:if test="${not empty movie.released}">
                            <i>Released:</i> ${movie.released}<br/>
                        </c:if>
                        <c:if test="${not empty movie.runtime}">
                            <i>Runtime:</i> ${movie.runtime}<br/>
                        </c:if>
                        <c:if test="${not empty movie.status}">
                            <i>Status:</i> ${movie.status}<br/>
                        </c:if>
                        <c:if test="${not empty movie.network}">
                            <i>Network:</i> ${movie.network}<br/>
                        </c:if>
                        <c:if test="${not empty movie.plot}">
                            <i>Plot:</i> ${movie.plot}<br/>
                        </c:if>
                        <hr/>
                    </div>
                </div>
            </div>
        </div>

        <tr>
            <td>
                <a href="#" data-toggle="modal" data-target="#movieModal${contor}">${movie.title}</a><br/>
                <smal style="font-size:10px;">${movie.genre}</smal>
            </td>
            <td>${movie.year}</td>
            <td>${movie.country}</td>
            <td>
                <c:choose>
                    <c:when test="${not empty movie.imdbRating}">
                        ${movie.imdbRating} from ${movie.imdbVotes} votes
                    </c:when>
                    <c:otherwise>
                        N/A
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:if test="${not empty movie.imdbID}">
                    <a href="http://www.imdb.com/title/${movie.imdbID}" target="_blank" title="IMDB">
                        <img src="/resources/images/imdb.png" />
                    </a>
                </c:if>
                <c:if test="${not empty movie.tvrageID}">
                    <a href="http://www.tvrage.com/shows/id-${movie.tvrageID}" target="_blank" title="TVRage">
                        <img src="/resources/images/tvrage.png" />
                    </a>
                </c:if>
            </td>
        </tr>
        <c:set var="contor" value="${contor + 1}" />
    </c:forEach>
    </tbody>
</table>

<ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <c:forEach var="i" begin="1" end="${pages}">
        <li><a href="/search/results?query=${param["query"]}&page=${i}">${i}</a></li>
    </c:forEach>
    <li><a href="#">&raquo;</a></li>
</ul>

<jsp:include page="footer.jsp" />