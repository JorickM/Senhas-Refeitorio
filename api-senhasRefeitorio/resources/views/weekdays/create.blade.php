@extends('weekdays.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
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
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection