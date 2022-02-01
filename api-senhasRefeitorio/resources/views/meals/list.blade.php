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
            <h2>Meals List.</h2>
        </div>
    </div>
    <div class="container px-4 px-lg-2 my-5">
        <table class="table table-bordered">
            <tr>
                <th>No</th>
                <th>Meal Code</th>
                <th>Weekday Code</th>
                <th>Main Dish</th>
                <th>Soup</th>
                <th>Desert</th>
                <th>Url</th>



                <th width="280px">Action</th>
            </tr>
            @php
            $i = 0;
            @endphp
            @foreach ($meals as $meal)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $meal->codMeal }}</td>
                <td>{{ $meal->codWeekday }}</td>
                <td>{{ $meal->mainDish }}</td>
                <td>{{ $meal->soup }}</td>
                <td>{{ $meal->desert }}</td>
                <td>{{ $meal->url }}</td>

                <td>
                    <form action="{{ route('meals.destroy',$meal->codMeal) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('meals.show',$meal->codMeal) }}">Show</a>
                        <a class="btn btn-primary" href="{{ route('meals.edit',$meal->codMeal) }}">Edit</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
            @endforeach
        </table>
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('meals.create') }}">Add</a>
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