@extends('meals.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Show Meal</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('meals') }}"> Back</a>
        </div>
    </div>
    <table class="table table-bordered">
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
@endsection