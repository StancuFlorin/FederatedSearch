<jsp:include page="header.jsp" />

<h1 class="page-header">${title}</h1>

<form class="form-horizontal" role="form" method="get" action="/search/results">
    <div class="form-group">
        <label for="inputName" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
            <input type="test" class="form-control" id="inputName" placeholder="Name" name="query">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Search</button>
        </div>
    </div>
</form>

<jsp:include page="footer.jsp" />