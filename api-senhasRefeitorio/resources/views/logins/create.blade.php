@extends('logins.layouts.app')

@section('content')

@if (Route::has('login'))
<div class="hidden fixed top-0 right-0 px-6 py-4 sm:block">
@auth

    <div class="row">
    <div class="col-lg-11 px-5">
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





    <div class="container px-4 px-lg-2 my-5">

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
        <br>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
    @else
    <div class="container px-4 px-lg-2 my-5">
        <div class="card-body">
            You are not logged in!
            <a href="{{ route('login') }}" class="text-sm text-gray-700 dark:text-gray-500 underline btn btn-info">Log in</a>
        </div>
    </div>
    @endauth
</div>
@endif

@endsection