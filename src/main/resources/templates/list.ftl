<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Product </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.product.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="type">Type</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.product.type" id="type" class=" username form-control input-sm" placeholder="Enter your Type" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="brand">Brand</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.product.brand" id="brand" class="form-control input-sm" placeholder="Enter your Brand." required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="color">Color</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.product.color" id="color" class="form-control input-sm" placeholder="Enter your color." required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="price">Price</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.product.price" id="price" class="form-control input-sm" placeholder="Enter your Price." required ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.product.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    
    
    
    
    <div class="panel-heading"><span class="lead" ><li><a href="#" ng-click="showDetails = ! showDetails">List of Products</a></li> </span></div>
    
    <div class="panel panel-default" ng-show="showDetails">
        <!-- Default panel contents -->
             <div style="padding:20px 0px 60px 0px">
			<span class="col-md-1" style="font-weight:bold">Search</span>
			<span class="col-md-3">
			<input type="text" class="form-control" ng-model="searchKeyword""/>
			</span>
		</div>
                
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>TYPE</th>
		                <th>BRAND</th>
		                <th>COLOR</th>
		                <th>PRICE</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllProducts()| filter: searchKeyword"">
		                <td>{{u.id}}</td>
		                <td>{{u.type}}</td>
		                <td>{{u.brand}}</td>
		                <td>{{u.color}}</td>
		                 <td>{{u.price}}</td>
		                <td><button type="button" ng-click="ctrl.editProduct(u.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeProduct(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>



  
  