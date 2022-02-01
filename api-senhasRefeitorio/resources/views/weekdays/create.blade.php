@extends('weekdays.layouts.app')

@section('content')

@if (Route::has('login'))
<div class="hidden fixed top-0 right-0 px-6 py-4 sm:block">
@auth

    <div class="row">
    <div class="col-lg-11 px-5">
            <h2>Add New Weekday</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('weekdays') }}"> Back</a>
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
    <form action="{{ route('weekdays.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="txtName">Name:</label>
            <input type="text" class="form-control" id="txtName" placeholder="Enter Name" name="txtName">
        </div>
        <div class="form-group">
            <label for="txtLastName">Date:</label>
            <input type="date" class="form-control" id="txtDate" placeholder="Enter Date" name="txtDate">
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