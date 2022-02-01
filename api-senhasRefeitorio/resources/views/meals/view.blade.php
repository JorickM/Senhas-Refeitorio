@extends('meals.layouts.app')

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
            <h2>Show Meals List.</h2>
        </div>
    </div>
    <div class="container px-4 px-lg-2 my-5">
    <table class="table table-bordered">
        <tr>
            <th>Meal Code:</th>
            <td>{{ $meal->codMeal }}</td>
        </tr>
        <tr>
            <th>Weekday Code:</th>
            <td>{{ $meal->codWeekday }}</td>
        </tr>
        <tr>
            <th>Main Dish:</th>
            <td>{{ $meal->mainDish }}</td>
        </tr>
        <tr>
            <th>Soup:</th>
            <td>{{ $meal->soup }}</td>
        </tr>
        <tr>
            <th>Desert:</th>
            <td>{{ $meal->desert }}</td>
        </tr>
        <tr>
            <th>Url:</th>
            <td>{{ $meal->url }}</td>
        </tr>
    </table>
    <br>
    <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('meals') }}"> Back</a>
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