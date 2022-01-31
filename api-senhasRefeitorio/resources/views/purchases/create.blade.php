@extends('purchases.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Add New Purchase</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('purchases') }}"> Back</a>
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
    <form action="{{ route('purchases.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="txtCodMeal">Meal Code:</label>
            <input type="number" class="form-control" id="txtCodMeal" placeholder="Enter Meal Code" name="txtCodMeal">
        </div>
        <div class="form-group">
            <label for="txtCodUser">User Code:</label>
            <input type="text" class="form-control" id="txtCodUser" placeholder="Enter User Code" name="txtCodUser">
        </div>
        <div class="form-group">
        <input type="radio" name="flgUsed" value=0 id="1" checked required />
        <label for="r1">Available</label>
         <input type="radio" name="tipo" value="docente" id="2" required />
         <label for="r2">Used</label>
    </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection