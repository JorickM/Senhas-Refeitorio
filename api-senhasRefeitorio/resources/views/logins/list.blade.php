@extends('logins.layouts.app')

@section('content')


@if ($message = Session::get('success'))
<div class="alert alert-success">
    <p>{{ $message }}</p>
</div>
@endif
@if (Route::has('login'))
<div class="hidden fixed top-0 right-0 px-6 py-4 sm:block">

    @auth

    <div class="row">
        <div class="col-lg-11 px-5">
            <h2>Login List.</h2>
        </div>
    </div>




    <div class="container px-4 px-lg-2 my-5">



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
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('logins.create') }}">Add</a>
        </div>
        <br>
        <div class="col-lg-2">
            <a class="btn btn-primary" href="{{ route('home') }}">Back</a>
        </div>
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