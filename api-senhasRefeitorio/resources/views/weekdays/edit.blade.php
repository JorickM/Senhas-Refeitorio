@extends('weekdays.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Update Weekdays</h2>
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

        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection