@extends('logins.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Laravel 8 CRUD Example</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('logins.create') }}">Add</a>
        </div>
    </div>

    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif

    @auth
    <table class="table table-bordered">
        <tr>
            <th>No</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Url</th>
            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($logins as $login)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $login->name }}</td>
                <td>{{ $login->lastName }}</td>
                <td>{{ $login->email }}</td>
                <td>{{ $login->password }}</td>
                <td>{{ $login->url }}</td>

                <td>
                    <form action="{{ route('logins.destroy',$login->codUser) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('logins.show',$login->codUser) }}">Show</a>
                        <a class="btn btn-primary" href="{{ route('logins.edit',$login->codUser) }}">Edit</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
    @endauth
@endsection