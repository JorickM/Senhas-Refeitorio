@extends('logins.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Laravel 8 CRUD Example</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('logins') }}"> Back</a>
        </div>
    </div>
    <table class="table table-bordered">
        <tr>
            <th>First Name:</th>
            <td>{{ $login->name }}</td>
        </tr>
        <tr>
            <th>Last Name:</th>
            <td>{{ $login->lastName }}</td>
        </tr>
        <tr>
            <th>Email:</th>
            <td>{{ $login->email }}</td>
        </tr>
        <tr>
            <th>Password:</th>
            <td>{{ $login->password }}</td>
        </tr>
        <tr>
            <th>url:</th>
            <td>{{ $login->url }}</td>
        </tr>
    </table>
@endsection