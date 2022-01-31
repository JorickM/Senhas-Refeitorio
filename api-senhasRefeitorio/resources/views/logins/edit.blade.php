@extends('logins.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Update Logins</h2>
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
    <form method="post" action="{{ route('logins.update',$login->codUser) }}" >
        @method('PATCH')
        @csrf
        <div class="form-group">
            <label for="txtFirstName">First Name:</label>
            <input type="text" class="form-control" id="txtName" placeholder="Enter First Name" name="txtFirstName" value="{{ $login->name }}">
        </div>
        <div class="form-group">
            <label for="txtLastName">Last Name:</label>
            <input type="text" class="form-control" id="txtLastName" placeholder="Enter Last Name" name="txtLastName" value="{{ $login->lastName }}">
        </div>

        <div class="form-group">
            <label for="txtEmail">Email:</label>
            <input type="text" class="form-control" id="txtEmail" placeholder="Enter Email" name="txtEmail" value="{{ $login->email }}">
        </div>

        <div class="form-group">
            <label for="txtPassword">Password:</label>
            <input type="text" class="form-control" id="txtPassword" placeholder="Enter Password" name="txtPassword" value="{{ $login->password }}">
        </div>
        <div class="form-group">
            <label for="txtUrl">Url:</label>
            <input type="text" class="form-control" id="txtUrç" placeholder="Enter Url" name="txtUrl" value="{{ $login->url }}">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection