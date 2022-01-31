@extends('logins.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Add New Login</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('logins') }}"> Back</a>
        </div>
    </div>

    @if ($errors->any())
        <div class="alert alert-danger">
            <strong>Whoops!</strong> There were some problems with your input.<br><br>
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif
    <form action="{{ route('logins.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="txtFirstName">First Name:</label>
            <input type="text" class="form-control" id="txtFirstName" placeholder="Enter First Name" name="txtFirstName">
        </div>
        <div class="form-group">
            <label for="txtLastName">Last Name:</label>
            <input type="text" class="form-control" id="txtLastName" placeholder="Enter Last Name" name="txtLastName">
        </div>
        <div class="form-group">
            <label for="txtEmail">Email:</label>
            <input type="text" class="form-control" id="txtEmail" placeholder="Enter Email" name="txtEmail">
        </div>
        <div class="form-group">
            <label for="txtAddress">Password:</label>
            <input type="text" class="form-control" id="txtPassword" placeholder="Enter Password" name="txtPassword">
        </div>
        <div class="form-group">
            <label for="txtUrl">Url:</label>
            <input type="text" class="form-control" id="txtUrl" placeholder="Enter Url" name="txtUrl">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection