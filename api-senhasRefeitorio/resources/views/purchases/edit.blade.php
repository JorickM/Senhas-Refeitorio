@extends('meals.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Update Meals</h2>
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
    <form method="post" action="{{ route('meals.update',$meal->codMeal) }}" >
        @method('PATCH')
        @csrf
        <div class="form-group">
            <label for="txtCodWeekday">Weekday Code:</label>
            <input type="number" class="form-control" id="txtCodWeekday" placeholder="Enter Name" name="txtCodWeekday" value="{{ $meal->codWeekday }}">
        </div>

        <div class="form-group">
            <label for="txtMainDish">Main Dish:</label>
            <input type="text" class="form-control" id="txtMainDish" placeholder="Enter Date" name="txtMainDish" value="{{ $meal->mainDish }}">
        </div>

        <div class="form-group">
            <label for="txtSoup">Soup:</label>
            <input type="text" class="form-control" id="txtSoup" placeholder="Enter Date" name="txtSoup" value="{{ $meal->soup }}">
        </div>

        <div class="form-group">
            <label for="txtDesert">Desert:</label>
            <input type="text" class="form-control" id="txtDesert" placeholder="Enter Date" name="txtDesert" value="{{ $meal->desert }}">
        </div>

        <div class="form-group">
            <label for="txtUrl">Url:</label>
            <input type="text" class="form-control" id="txtUrl" placeholder="Enter Date" name="txtUrl" value="{{ $meal->url }}">
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection