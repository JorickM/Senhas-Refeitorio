<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Weekdays extends Model
{
    use HasFactory;
    protected $table = 'weekdays';
    protected $fillable = ['name', 'date'];

    //public function meal(){
    //return $this->belongsTo(Meal::class);
    //}
}


