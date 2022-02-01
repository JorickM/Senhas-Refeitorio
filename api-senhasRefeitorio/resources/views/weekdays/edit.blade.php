@extends('weekdays.layouts.app')

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
            <h2>Update Weekdays</h2>
        </div>
    </div>
    
    <div class="container px-4 px-lg-2 my-5">
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
    <form method="post" action="{{ route('weekdays.update',$weekday->codWeekday) }}" >
        @method('PATCH')
        @csrf
        <div class="form-group">
            <label for="txtFirstName">Name:</label>
            <input type="text" class="form-control" id="txtName" placeholder="Enter Name" name="txtName" value="{{ $weekday->name }}">
        </div>
        <div class="form-group">
            <label for="txtDate">Date:</label>
            <input type="date" class="form-control" id="txtDate" placeholder="Enter Date" name="txtDate" value="{{ $weekday->date }}">
        </div>

        <button type="submit" class="btn btn-info">Submit</button>
    </form>
    <br>
    <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('weekdays') }}"> Back</a>
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