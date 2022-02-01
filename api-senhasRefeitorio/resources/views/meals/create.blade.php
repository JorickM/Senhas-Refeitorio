@extends('meals.layouts.app')

@section('content')

@if (Route::has('login'))
<div class="hidden fixed top-0 right-0 px-6 py-4 sm:block">
@auth

    <div class="row">
    <div class="col-lg-11 px-5">
            <h2>Add New Meal</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('meals') }}"> Back</a>
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

    <form action="{{ route('meals.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="txtCodWeekday">CodWeekday:</label>
            <input type="number" class="form-control" id="txtCodWeekday" placeholder="Enter Weekday Code" name="txtCodWeekday">
        </div>
        <div class="form-group">
            <label for="txtMainDish">Main Dish:</label>
            <input type="text" class="form-control" id="txtMainDish" placeholder="Enter Main Dish" name="txtMainDish">
        </div>
        <div class="form-group">
            <label for="txtSoup">Soup:</label>
            <input type="text" class="form-control" id="txtSoup" placeholder="Enter Soup" name="txtSoup">
        </div>
        <div class="form-group">
            <label for="txtDesert">Desert:</label>
            <input type="text" class="form-control" id="txtDesert" placeholder="Enter Desert" name="txtDesert">
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